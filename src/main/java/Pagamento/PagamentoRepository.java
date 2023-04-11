package Pagamento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Pagamento\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Pagamento\" WHERE \"idPagamento\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Pagamento\" (data, \"valorPago\", \"tipoPagamento\", \"idUtilizador\", \"idFatura\") VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Pagamento\" SET data = ?, \"valorPago\" = ?, \"tipoPagamento\" = ?, \"idUtilizador\" = ?, \"idFatura\" = ? WHERE \"idPagamento\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Pagamento\" WHERE \"idPagamento\"= ?";

    public List<Pagamento> getAllPagamentos() throws SQLException {
        List<Pagamento> pagamentos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setData(rs.getDate("data"));
                pagamento.setValorPago(rs.getFloat("valorPago"));
                pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
                pagamento.setIdUtilizador(rs.getInt("idUtilizador"));
                pagamento.setIdFatura(rs.getInt("idFatura"));
                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }

    public Pagamento savePagamento(Pagamento pagamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, pagamento.getData());
            pstmt.setFloat(2, pagamento.getValorPago());
            pstmt.setString(3, pagamento.getTipoPagamento());
            pstmt.setInt(4, pagamento.getIdUtilizador());
            pstmt.setInt(5, pagamento.getIdFatura());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setIdPagamento(rs.getInt(1));
                }
            }
        }
        return pagamento;
    }

    public Pagamento findPagamentoById(int id) throws SQLException {
        Pagamento pagamento = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pagamento = new Pagamento();
                    pagamento.setData(rs.getDate("data"));
                    pagamento.setValorPago(rs.getFloat("valorPago"));
                    pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
                    pagamento.setIdUtilizador(rs.getInt("idUtilizador"));
                    pagamento.setIdFatura(rs.getInt("idFatura"));
                }
            }
        }
        return pagamento;
    }

    public Pagamento updatePagamento(Pagamento pagamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setDate(1, pagamento.getData());
            pstmt.setFloat(2, pagamento.getValorPago());
            pstmt.setString(3, pagamento.getTipoPagamento());
            pstmt.setInt(4, pagamento.getIdUtilizador());
            pstmt.setInt(5, pagamento.getIdFatura());
            pstmt.executeUpdate();
        }
        return pagamento;
    }

    public void deletePagamento(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
