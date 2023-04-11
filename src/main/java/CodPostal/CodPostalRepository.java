package CodPostal;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CodPostalRepository {


    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"CodPostal\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"CodPostal\" WHERE \"cpostal\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"CodPostal\" (localidade) VALUES (?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"CodPostal\" SET localidade = ? WHERE \"cpostal\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"CodPostal\" WHERE \"cpostal\"= ?";

    public List<CodPostal> getAllCodPostals() throws SQLException {
        List<CodPostal> codPostals = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                CodPostal codPostal = new CodPostal();
                codPostal.setLocalidade(rs.getString("localidade"));
                codPostals.add(codPostal);
            }
        }
        return codPostals;
    }

    public CodPostal saveCodPostal(CodPostal codPostal) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, codPostal.getLocalidade());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    codPostal.setCpostal(rs.getString(1));
                }
            }
        }
        return codPostal;
    }

    public CodPostal findCodPostalByCpostal(String cpostal) throws SQLException {
        CodPostal codPostal = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setString(1, cpostal);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    codPostal = new CodPostal();
                    codPostal.setLocalidade(rs.getString("localidade"));
                }
            }
        }
        return codPostal;
    }

    public CodPostal updateCodPostal(CodPostal codPostal) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, codPostal.getLocalidade());
            pstmt.executeUpdate();
        }
        return codPostal;
    }

    public void deleteCodPostal(String cpostal) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, cpostal);
            pstmt.executeUpdate();
        }
    }
}





