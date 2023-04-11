package Comprimento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComprimentoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Comprimento\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Comprimento\" WHERE \"comprimento\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Comprimento\" (descricao, \"valorComprimento\") VALUES (?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Comprimento\" SET descricao = ?, \"valorComprimento\" = ? WHERE \"comprimento\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Comprimento\" WHERE \"comprimento\"= ?";

    public List<Comprimento> getAllComprimentos() throws SQLException {
        List<Comprimento> comprimentos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Comprimento comprimento = new Comprimento();
                comprimento.setDescricao(rs.getString("descricao"));
                comprimento.setValorComprimento(rs.getFloat("valorComprimento"));
                comprimentos.add(comprimento);
            }
        }
        return comprimentos;
    }

    public Comprimento saveComprimento(Comprimento comprimento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, comprimento.getDescricao());
            pstmt.setFloat(2, comprimento.getValorComprimento());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    comprimento.setComprimento(rs.getInt(1));
                }
            }
        }
        return comprimento;
    }

    public Comprimento findComprimentoById(int id) throws SQLException {
        Comprimento comprimento = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    comprimento = new Comprimento();
                    comprimento.setDescricao(rs.getString("descricao"));
                    comprimento.setValorComprimento(rs.getFloat("valorComprimento"));
                }
            }
        }
        return comprimento;
    }

    public Comprimento updateComprimento(Comprimento comprimento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, comprimento.getDescricao());
            pstmt.setFloat(2, comprimento.getValorComprimento());
            pstmt.executeUpdate();
        }
        return comprimento;
    }

    public void deleteComprimento(int comprimento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, comprimento);
            pstmt.executeUpdate();
        }
    }
}







