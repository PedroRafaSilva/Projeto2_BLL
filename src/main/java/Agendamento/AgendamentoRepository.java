package Agendamento;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepository {

        private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Agendamento\"";
        private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Agendamento\" WHERE \"idAgendamento\" = ?";
        private static final String INSERT = "INSERT INTO \"Projecto1\".\"Agendamento\" (data, \"valorExtras\", hora, duracao, \"idEmbarcacao\", \"idFatura\", \"idUtilizador\") VALUES (?, ?, ?, ?, ?, ?, ?)";
        private static final String UPDATE = "UPDATE \"Projecto1\".\"Agendamento\" SET data = ?, \"valorExtras\" = ?, hora = ?, duracao = ?, \"idEmbarcacao\" = ?, \"idFatura\" = ?, \"idUtilizador\" = ? WHERE \"idAgendamento\" = ?";
        private static final String DELETE = "DELETE FROM \"Projecto1\".\"Agendamento\" WHERE \"idAgendamento\"= ?";

        public List<Agendamento> getAllAgendamentos() throws SQLException {
            List<Agendamento> agendamentos = new ArrayList<>();

            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
                while (rs.next()) {
                    Agendamento agendamento = new Agendamento();
                    agendamento.setData(rs.getDate("data"));
                    agendamento.setValorExtras(rs.getFloat("valorExtras"));
                    agendamento.setHora(rs.getTime("hora"));
                    agendamento.setDuracao(rs.getObject("duracao"));
                    agendamento.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                    agendamento.setIdFatura(rs.getInt("idFatura"));
                    agendamento.setIdUtilizador(rs.getInt("idUtilizador"));
                    agendamentos.add(agendamento);
                }
            }
            return agendamentos;
        }

        public Agendamento saveAgendamento(Agendamento agendamento) throws SQLException {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setDate(1, agendamento.getData());
                pstmt.setFloat(2, agendamento.getValorExtras());
                pstmt.setTime(3, agendamento.getHora());
                pstmt.setObject(4, agendamento.getDuracao());
                pstmt.setInt(5, agendamento.getIdEmbarcacao());
                pstmt.setInt(6, agendamento.getIdFatura());
                pstmt.setInt(7, agendamento.getIdUtilizador());
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        agendamento.setIdAgendamento(rs.getInt(1));
                    }
                }
            }
            return agendamento;
        }

        public Agendamento findAgendamentoById(int id) throws SQLException {
            Agendamento agendamento = null;
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        agendamento = new Agendamento();
                        agendamento.setData(rs.getDate("data"));
                        agendamento.setValorExtras(rs.getFloat("valorExtras"));
                        agendamento.setHora(rs.getTime("hora"));
                        agendamento.setDuracao(rs.getObject("duracao"));
                        agendamento.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                        agendamento.setIdFatura(rs.getInt("idFatura"));
                        agendamento.setIdUtilizador(rs.getInt("idUtilizador"));
                    }
                }
            }
            return agendamento;
        }

        public Agendamento updateAgendamento(Agendamento agendamento) throws SQLException {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
                pstmt.setDate(1, agendamento.getData());
                pstmt.setFloat(2, agendamento.getValorExtras());
                pstmt.setTime(3, agendamento.getHora());
                pstmt.setObject(4, agendamento.getDuracao());
                pstmt.setInt(5, agendamento.getIdEmbarcacao());
                pstmt.setInt(6, agendamento.getIdFatura());
                pstmt.setInt(7, agendamento.getIdUtilizador());
                pstmt.executeUpdate();
            }
            return agendamento;
        }

        public void deleteAgendamento(int id) throws SQLException {
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        }
}


