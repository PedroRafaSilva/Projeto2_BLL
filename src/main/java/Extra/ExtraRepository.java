package Extra;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExtraRepository {

        private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Extra\"";
        private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Extra\" WHERE \"idExtra\" = ?";
        private static final String INSERT = "INSERT INTO \"Projecto1\".\"Extra\" (descricao, \"valorAtualExtra\") VALUES (?, ?)";
        private static final String UPDATE = "UPDATE \"Projecto1\".\"Extra\" SET descricao = ?, \"valorAtualExtra\" = ? WHERE \"idExtra\" = ?";
        private static final String DELETE = "DELETE FROM \"Projecto1\".\"Extra\" WHERE \"idExtra\"= ?";

        public List<Extra> getAllExtras() throws SQLException {
            List<Extra> extras = new ArrayList<>();

            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
                while (rs.next()) {
                    Extra extra = new Extra();
                    extra.setIdExtra(rs.getInt("idExtra"));
                    extra.setDescricao(rs.getString("descricao"));
                    extra.setValorAtualExtra(rs.getFloat("valorAtualExtra"));
                    extras.add(extra);
                }
            }
            return extras;
        }

        public Extra saveExtra(Extra extra) throws SQLException {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, extra.getDescricao());
                pstmt.setFloat(2, extra.getValorAtualExtra());
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        extra.setIdExtra(rs.getInt(1));
                    }
                }
            }
            return extra;
        }

    public Extra findExtraById(int id) throws SQLException {
        Extra extra = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    extra = new Extra();
                    extra.setIdExtra(rs.getInt("idExtra"));
                    extra.setDescricao(rs.getString("descricao"));
                    extra.setValorAtualExtra(rs.getFloat("valorAtualExtra"));
                }
            }
        }
        return extra;
    }

    public Extra updateExtra(Extra extra) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, extra.getDescricao());
            pstmt.setFloat(2, extra.getValorAtualExtra());
            pstmt.setInt(3, extra.getIdExtra());
            pstmt.executeUpdate();
        }
        return extra;
    }

    public void deleteExtra(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}


