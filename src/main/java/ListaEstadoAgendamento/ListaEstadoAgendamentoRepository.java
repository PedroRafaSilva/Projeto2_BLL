package ListaEstadoAgendamento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEstadoAgendamentoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"ListaEstadoAgendamento\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"ListaEstadoAgendamento\" WHERE \"idAgendamento\" = ? AND \"idFatura\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"ListaEstadoAgendamento\" (\"idAgendamento\", \"idEstado\", \"data\") VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"ListaEstadoAgendamento\" SET \"idAgendamento\" = ?, \"idEstado\" = ?, \"data\" = ? WHERE \"idAgendamento\" = ? AND \"idFatura\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"ListaEstadoAgendamento\" WHERE \"idAgendamento\" = ? AND \"idFatura\" = ?";

    public List<ListaEstadoAgendamento> getAllListaEstadoAgendamentos() throws SQLException {
        List<ListaEstadoAgendamento> listaEstadoAgendamentos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                ListaEstadoAgendamento listaEstadoAgendamento = new ListaEstadoAgendamento();
                listaEstadoAgendamento.setIdAgendamento(rs.getInt("idAgendamento"));
                listaEstadoAgendamento.setIdEstado(rs.getInt("idEstado"));
                listaEstadoAgendamento.setData(rs.getDate("data"));
                listaEstadoAgendamentos.add(listaEstadoAgendamento);
            }
        }
        return listaEstadoAgendamentos;
    }

    public ListaEstadoAgendamento saveListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, listaEstadoAgendamento.getIdAgendamento());
            pstmt.setInt(2, listaEstadoAgendamento.getIdEstado());
            pstmt.setDate(3, listaEstadoAgendamento.getData());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    listaEstadoAgendamento.setIdAgendamento(rs.getInt(1));
                    listaEstadoAgendamento.setIdEstado(rs.getInt(2));
                }
            }
        }
        return listaEstadoAgendamento;
    }

    public ListaEstadoAgendamento findListaEstadoAgendamentoByIds(int id, int id2) throws SQLException {
        ListaEstadoAgendamento listaEstadoAgendamento = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id2);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    listaEstadoAgendamento = new ListaEstadoAgendamento();
                    listaEstadoAgendamento.setIdAgendamento(rs.getInt("idAgendamento"));
                    listaEstadoAgendamento.setIdEstado(rs.getInt("idEstado"));
                    listaEstadoAgendamento.setData(rs.getDate("data"));
                }
            }
        }
        return listaEstadoAgendamento;
    }

    public ListaEstadoAgendamento updateListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, listaEstadoAgendamento.getIdAgendamento());
            pstmt.setInt(2, listaEstadoAgendamento.getIdEstado());
            pstmt.setDate(3, listaEstadoAgendamento.getData());
            pstmt.executeUpdate();
        }
        return listaEstadoAgendamento;
    }

    public void deleteListaEstadoAgendamento(int id, int id2) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.setInt(1, id2);
            pstmt.executeUpdate();
        }
    }
}


