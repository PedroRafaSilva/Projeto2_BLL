package AgendamentoExtra;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoExtraRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"AgendamentoExtra\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"AgendamentoExtra\" WHERE \"idAgendamento\" = ? AND \"idExtra\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"AgendamentoExtra\" (\"idAgendamento\", \"idExtra\", \"valorExtra\", qtd) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"AgendamentoExtra\" SET \"idAgendamento\" = ?, \"idExtra\" = ?, \"valorExtra\" = ?, qtd = ? WHERE  \"idAgendamento\" = ? AND \"idExtra\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"AgendamentoExtra\" WHERE \"idAgendamento\" = ? AND \"idExtra\" = ?";

    public List<AgendamentoExtra> getAllAgendamentoExtras() throws SQLException {
        List<AgendamentoExtra> agendamentoExtras = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                AgendamentoExtra agendamentoExtra = new AgendamentoExtra();
                agendamentoExtra.setIdAgendamento(rs.getInt("idAgendamento"));
                agendamentoExtra.setIdExtra(rs.getInt("idExtra"));
                agendamentoExtra.setValorExtra(rs.getFloat("valorExtra"));
                agendamentoExtra.setQtd(rs.getInt("qtd"));
                agendamentoExtras.add(agendamentoExtra);
            }
        }
        return agendamentoExtras;
    }

    public AgendamentoExtra saveAgendamentoExtra(AgendamentoExtra agendamentoExtra) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, agendamentoExtra.getIdAgendamento());
            pstmt.setInt(2, agendamentoExtra.getIdExtra());
            pstmt.setFloat(3, agendamentoExtra.getValorExtra());
            pstmt.setInt(4, agendamentoExtra.getQtd());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    agendamentoExtra.setIdAgendamento(rs.getInt(1));
                    agendamentoExtra.setIdExtra(rs.getInt(2));
                }
            }
        }
        return agendamentoExtra;
    }

    public AgendamentoExtra findAgendamentoExtraByIds(int id, int id2) throws SQLException {
        AgendamentoExtra agendamentoExtra = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id2);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    agendamentoExtra = new AgendamentoExtra();
                    agendamentoExtra.setIdAgendamento(rs.getInt("idAgendamento"));
                    agendamentoExtra.setIdExtra(rs.getInt("idExtra"));
                    agendamentoExtra.setValorExtra(rs.getFloat("valorExtra"));
                    agendamentoExtra.setQtd(rs.getInt("qtd"));
                }
            }
        }
        return agendamentoExtra;
    }

    public AgendamentoExtra updateAgendamentoExtra(AgendamentoExtra agendamentoExtra) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, agendamentoExtra.getIdAgendamento());
            pstmt.setInt(2, agendamentoExtra.getIdExtra());
            pstmt.setFloat(3, agendamentoExtra.getValorExtra());
            pstmt.setInt(4, agendamentoExtra.getQtd());
            pstmt.executeUpdate();
        }
        return agendamentoExtra;
    }

    public void deleteAgendamentoExtra(int id, int id2) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.setInt(1, id2);
            pstmt.executeUpdate();
        }
    }
}







