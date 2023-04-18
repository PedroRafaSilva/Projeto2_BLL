package Utilizador;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilizadorRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Utilizador\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Utilizador\" WHERE \"idUtilizador\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Utilizador\" (nome, telefone, email, nif, rua, porta, \"cPostal\", \"idTipoUtilizador\", username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Utilizador\" SET nome = ?, telefone = ?, email = ?, nif = ?, rua = ?, porta = ?, \"cPostal\" = ?, \"idTipoUtilizador\" = ?, username = ?, password = ? WHERE \"idUtilizador\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Utilizador\" WHERE \"idUtilizador\"= ?";

    public List<Utilizador> getAllUtilizadors() throws SQLException {
        List<Utilizador> utilizadors = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Utilizador utilizador = new Utilizador();
                utilizador.setNome(rs.getString("nome"));
                utilizador.setTelefone(rs.getString("telefone"));
                utilizador.setEmail(rs.getString("email"));
                utilizador.setNif(rs.getInt("nif"));
                utilizador.setRua(rs.getString("rua"));
                utilizador.setPorta(rs.getInt("porta"));
                utilizador.setcPostal(rs.getString("cPostal"));
                utilizador.setIdTipoUtilizador(rs.getInt("idTipoUtilizador"));
                utilizador.setUsername(rs.getString("username"));
                utilizador.setPassword(rs.getString("password"));
                utilizadors.add(utilizador);
            }
        }
        return utilizadors;
    }

    public Utilizador saveUtilizador(Utilizador utilizador) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, utilizador.getNome());
            pstmt.setString(2, utilizador.getTelefone());
            pstmt.setString(3, utilizador.getEmail());
            pstmt.setInt(4, utilizador.getNif());
            pstmt.setString(5, utilizador.getRua());
            pstmt.setInt(6, utilizador.getPorta());
            pstmt.setString(7, utilizador.getcPostal());
            pstmt.setInt(8, utilizador.getIdTipoUtilizador());
            pstmt.setString(9, utilizador.getUsername());
            pstmt.setString(10, utilizador.getPassword());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    utilizador.setIdUtilizador(rs.getInt(1));
                }
            }
        }
        return utilizador;
    }

    public Utilizador findUtilizadorById(int id) throws SQLException {
        Utilizador utilizador = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    utilizador = new Utilizador();
                    utilizador.setNome(rs.getString("nome"));
                    utilizador.setTelefone(rs.getString("telefone"));
                    utilizador.setEmail(rs.getString("email"));
                    utilizador.setNif(rs.getInt("nif"));
                    utilizador.setRua(rs.getString("rua"));
                    utilizador.setPorta(rs.getInt("porta"));
                    utilizador.setcPostal(rs.getString("cPostal"));
                    utilizador.setIdTipoUtilizador(rs.getInt("idTipoUtilizador"));
                    utilizador.setUsername(rs.getString("username"));
                    utilizador.setPassword(rs.getString("password"));
                }
            }
        }
        return utilizador;
    }

    public Utilizador updateUtilizador(Utilizador utilizador) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, utilizador.getNome());
            pstmt.setString(2, utilizador.getTelefone());
            pstmt.setString(3, utilizador.getEmail());
            pstmt.setInt(4, utilizador.getNif());
            pstmt.setString(5, utilizador.getRua());
            pstmt.setInt(6, utilizador.getPorta());
            pstmt.setString(7, utilizador.getcPostal());
            pstmt.setInt(8, utilizador.getIdTipoUtilizador());
            pstmt.setString(9, utilizador.getUsername());
            pstmt.setString(10, utilizador.getPassword());
            pstmt.executeUpdate();
        }
        return utilizador;
    }

    public void deleteUtilizador(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

