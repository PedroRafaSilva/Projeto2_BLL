package EstadoAgendamento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoAgendamentoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"EstadoAgendamento\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"EstadoAgendamento\" WHERE \"idEstado\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"EstadoAgendamento\" (\"Estado\") VALUES (?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"EstadoAgendamento\" SET \"Estado\" = ? WHERE \"idEstado\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"EstadoAgendamento\" WHERE \"idEstado\"= ?";

    public List<EstadoAgendamento> getAllEstadoAgendamentos() throws SQLException {
        List<EstadoAgendamento> estadoAgendamentos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                EstadoAgendamento estadoAgendamento = new EstadoAgendamento();
                estadoAgendamento.setEstado(rs.getString("Estado"));
                estadoAgendamentos.add(estadoAgendamento);
            }
        }
        return estadoAgendamentos;
    }

    public EstadoAgendamento saveEstadoAgendamento(EstadoAgendamento estadoAgendamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, estadoAgendamento.getEstado());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    estadoAgendamento.setIdEstado(rs.getInt(1));
                }
            }
        }
        return estadoAgendamento;
    }

    public EstadoAgendamento findEstadoAgendamentoById(String idEstado) throws SQLException {
        EstadoAgendamento estadoAgendamento = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setString(1, idEstado);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    estadoAgendamento = new EstadoAgendamento();
                    estadoAgendamento.setEstado(rs.getString("Estado"));
                }
            }
        }
        return estadoAgendamento;
    }

    public EstadoAgendamento updateEstadoAgendamento(EstadoAgendamento estadoAgendamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, estadoAgendamento.getEstado());
            pstmt.executeUpdate();
        }
        return estadoAgendamento;
    }

    public void deleteEstadoAgendamento(String idEstado) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setString(1, idEstado);
            pstmt.executeUpdate();
        }
    }
}


