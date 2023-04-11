package TipoUtilizador;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoUtilizadorRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"TipoUtilizador\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"TipoUtilizador\" WHERE \"idTipoUtilizador\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"TipoUtilizador\" (\"descricao\") VALUES (?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"TipoUtilizador\" SET \"descricao\" = ? WHERE \"idTipoUtilizador\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"TipoUtilizador\" WHERE \"idTipoUtilizador\"= ?";

    public List<TipoUtilizador> getAllTipoUtilizadors() throws SQLException {
        List<TipoUtilizador> tipoUtilizadors = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                TipoUtilizador tipoUtilizador = new TipoUtilizador();
                tipoUtilizador.setDescricao(rs.getString("descricao"));
                tipoUtilizadors.add(tipoUtilizador);
            }
        }
        return tipoUtilizadors;
    }

    public TipoUtilizador saveTipoUtilizador(TipoUtilizador tipoUtilizador) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, tipoUtilizador.getIdTipoUtilizador());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tipoUtilizador.setIdTipoUtilizador(rs.getInt(1));
                }
            }
        }
        return tipoUtilizador;
    }

    public TipoUtilizador findTipoUtilizadorById(String idTipoUtilizador) throws SQLException {
        TipoUtilizador tipoUtilizador = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setString(1, idTipoUtilizador);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tipoUtilizador = new TipoUtilizador();
                    tipoUtilizador.setDescricao(rs.getString("descricao"));
                }
            }
        }
        return tipoUtilizador;
    }

    public TipoUtilizador updateTipoUtilizador(TipoUtilizador tipoUtilizador) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, tipoUtilizador.getIdTipoUtilizador());
            pstmt.executeUpdate();
        }
        return tipoUtilizador;
    }

    public void deleteTipoUtilizador(int idTipoUtilizador) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, idTipoUtilizador);
            pstmt.executeUpdate();
        }
    }
}

