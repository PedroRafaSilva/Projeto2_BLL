package Oficina;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OficinaRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Oficina\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Oficina\" WHERE \"idOficina\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Oficina\" (nome, cpostal) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Oficina\" SET nome = ?, cpostal = ? WHERE \"idOficina\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Oficina\" WHERE \"idOficina\"= ?";

    public List<Oficina> getAllOficinas() throws SQLException {
        List<Oficina> oficinas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Oficina oficina = new Oficina();
                oficina.setNome(rs.getString("nome"));
                oficina.setCpostal(rs.getString("cpostal"));
                oficinas.add(oficina);
            }
        }
        return oficinas;
    }

    public Oficina saveOficina(Oficina oficina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, oficina.getNome());
            pstmt.setString(2, oficina.getCpostal());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    oficina.setIdOficina(rs.getInt(1));
                }
            }
        }
        return oficina;
    }

    public Oficina findOficinaById(int id) throws SQLException {
        Oficina oficina = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    oficina = new Oficina();
                    oficina.setNome(rs.getString("nome"));
                    oficina.setCpostal(rs.getString("cpostal"));
                }
            }
        }
        return oficina;
    }

    public Oficina updateOficina(Oficina oficina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, oficina.getNome());
            pstmt.setString(2, oficina.getCpostal());
            pstmt.executeUpdate();
        }
        return oficina;
    }

    public void deleteOficina(int oficina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, oficina);
            pstmt.executeUpdate();
        }
    }
}


