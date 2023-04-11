package Fatura;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FaturaRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Fatura\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Fatura\" WHERE \"idFatura\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Fatura\" (\"dataCriacao\", prazo, \"valorEmbarcacoes\", \"valorAgendamento\", \"valorManutencao\", \"valorTotal\", \"idUtilizador\", \"numFiscal\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Fatura\" SET \"dataCriacao\" = ?, prazo = ?, \"valorEmbarcacoes\" = ?, \"valorAgendamento\" = ?, \"valorManutencao\" = ?, \"valorTotal\" = ?, \"idUtilizador\" = ?, \"numFiscal\" = ? WHERE \"idFatura\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Fatura\" WHERE \"idFatura\"= ?";

    public List<Fatura> getAllFaturas() throws SQLException {
        List<Fatura> faturas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setDataCriacao(rs.getDate("dataCriacao"));
                fatura.setPrazo(rs.getDate("prazo"));
                fatura.setValorEmbarcacoes(rs.getFloat("valorEmbarcacoes"));
                fatura.setValorAgendamento(rs.getFloat("valorAgendamento"));
                fatura.setValorManutencao(rs.getFloat("valorManutencao"));
                fatura.setValorTotal(rs.getFloat("valorTotal"));
                fatura.setIdUtilizador(rs.getInt("idUtilizador"));
                fatura.setNumFiscal(rs.getInt("numFiscal"));
                faturas.add(fatura);
            }
        }
        return faturas;
    }

    public Fatura saveFatura(Fatura fatura) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, fatura.getDataCriacao());
            pstmt.setDate(2, fatura.getPrazo());
            pstmt.setFloat(3, fatura.getValorEmbarcacoes());
            pstmt.setFloat(4, fatura.getValorAgendamento());
            pstmt.setFloat(5, fatura.getValorManutencao());
            pstmt.setFloat(6, fatura.getValorTotal());
            pstmt.setInt(7, fatura.getIdUtilizador());
            pstmt.setInt(8, fatura.getNumFiscal());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    fatura.setIdFatura(rs.getInt(1));
                }
            }
        }
        return fatura;
    }

    public Fatura findFaturaById(int id) throws SQLException {
        Fatura fatura = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    fatura = new Fatura();
                    fatura.setDataCriacao(rs.getDate("dataCriacao"));
                    fatura.setPrazo(rs.getDate("prazo"));
                    fatura.setValorEmbarcacoes(rs.getFloat("valorEmbarcacoes"));
                    fatura.setValorAgendamento(rs.getFloat("valorAgendamento"));
                    fatura.setValorManutencao(rs.getFloat("valorManutencao"));
                    fatura.setValorTotal(rs.getFloat("valorTotal"));
                    fatura.setIdUtilizador(rs.getInt("idUtilizador"));
                    fatura.setNumFiscal(rs.getInt("numFiscal"));
                }
            }
        }
        return fatura;
    }

    public Fatura updateFatura(Fatura fatura) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setDate(1, fatura.getDataCriacao());
            pstmt.setDate(2, fatura.getPrazo());
            pstmt.setFloat(3, fatura.getValorEmbarcacoes());
            pstmt.setFloat(4, fatura.getValorAgendamento());
            pstmt.setFloat(5, fatura.getValorManutencao());
            pstmt.setFloat(6, fatura.getValorTotal());
            pstmt.setInt(7, fatura.getIdUtilizador());
            pstmt.setInt(8, fatura.getNumFiscal());
            pstmt.executeUpdate();
        }
        return fatura;
    }

    public void deleteFatura(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
