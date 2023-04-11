package Marina;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarinaRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Marina\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Marina\" WHERE \"idMarina\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Marina\" (nome, cpostal) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Marina\" SET nome = ?, cpostal = ? WHERE \"idMarina\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Marina\" WHERE \"idMarina\"= ?";

    public List<Marina> getAllMarinas() throws SQLException {
        List<Marina> marinas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Marina marina = new Marina();
                marina.setNome(rs.getString("nome"));
                marina.setCpostal(rs.getString("cpostal"));
                marinas.add(marina);
            }
        }
        return marinas;
    }

    public Marina saveMarina(Marina marina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, marina.getNome());
            pstmt.setString(2, marina.getCpostal());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    marina.setIdMarina(rs.getInt(1));
                }
            }
        }
        return marina;
    }

    public Marina findMarinaById(int id) throws SQLException {
        Marina marina = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    marina = new Marina();
                    marina.setNome(rs.getString("nome"));
                    marina.setCpostal(rs.getString("cpostal"));
                }
            }
        }
        return marina;
    }

    public Marina updateMarina(Marina marina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, marina.getNome());
            pstmt.setString(2, marina.getCpostal());
            pstmt.executeUpdate();
        }
        return marina;
    }

    public void deleteMarina(int marina) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, marina);
            pstmt.executeUpdate();
        }
    }
}









