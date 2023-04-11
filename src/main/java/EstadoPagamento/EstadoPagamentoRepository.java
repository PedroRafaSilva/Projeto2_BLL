package EstadoPagamento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoPagamentoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"EstadoPagamento\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"EstadoPagamento\" WHERE \"idEstado\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"EstadoPagamento\" (\"Estado\") VALUES (?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"EstadoPagamento\" SET \"Estado\" = ? WHERE \"idEstado\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"EstadoPagamento\" WHERE \"idEstado\"= ?";

    public List<EstadoPagamento> getAllEstadoPagamentos() throws SQLException {
        List<EstadoPagamento> estadoPagamentos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                EstadoPagamento estadoPagamento = new EstadoPagamento();
                estadoPagamento.setEstado(rs.getString("Estado"));
                estadoPagamentos.add(estadoPagamento);
            }
        }
        return estadoPagamentos;
    }

    public EstadoPagamento saveEstadoPagamento(EstadoPagamento estadoPagamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, estadoPagamento.getEstado());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    estadoPagamento.setIdEstado(rs.getInt(1));
                }
            }
        }
        return estadoPagamento;
    }

    public EstadoPagamento findEstadoPagamentoById(String idEstado) throws SQLException {
        EstadoPagamento estadoPagamento = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setString(1, idEstado);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    estadoPagamento = new EstadoPagamento();
                    estadoPagamento.setEstado(rs.getString("Estado"));
                }
            }
        }
        return estadoPagamento;
    }

    public EstadoPagamento updateEstadoPagamento(EstadoPagamento estadoPagamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, estadoPagamento.getEstado());
            pstmt.executeUpdate();
        }
        return estadoPagamento;
    }

    public void deleteEstadoPagamento(String idEstado) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, idEstado);
            pstmt.executeUpdate();
        }
    }
}







