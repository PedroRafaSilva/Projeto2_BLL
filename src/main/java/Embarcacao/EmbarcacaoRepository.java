package Embarcacao;


import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmbarcacaoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"Embarcacao\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"Embarcacao\" WHERE \"idEmbarcacao\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"Embarcacao\" (nome, comprimento, \"idUtilizador\", \"idMarina\") VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"Embarcacao\" SET nome = ?, comprimento = ?, \"idUtilizador\" = ?, \"idMarina\" = ? WHERE \"idEmbarcacao\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"Embarcacao\" WHERE \"idEmbarcacao\"= ?";

    public List<Embarcacao> getAllEmbarcacoes() throws SQLException {
        List<Embarcacao> embarcacoes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Embarcacao embarcacao = new Embarcacao();
                embarcacao.setNome(rs.getString("nome"));
                embarcacao.setComprimento(rs.getInt("comprimento"));
                embarcacao.setIdUtilizador(rs.getInt("idUtilizador"));
                embarcacao.setIdMarina(rs.getInt("idMarina"));
                embarcacoes.add(embarcacao);
            }
        }
        return embarcacoes;
    }

    public Embarcacao saveEmbarcacao(Embarcacao embarcacao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, embarcacao.getNome());
            pstmt.setInt(2, embarcacao.getComprimento());
            pstmt.setInt(3, embarcacao.getIdUtilizador());
            pstmt.setInt(4, embarcacao.getIdMarina());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    embarcacao.setIdEmbarcacao(rs.getInt(1));
                }
            }
        }
        return embarcacao;
    }

    public Embarcacao findEmbarcacaoById(int id) throws SQLException {
        Embarcacao embarcacao = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    embarcacao = new Embarcacao();
                    embarcacao.setNome(rs.getString("nome"));
                    embarcacao.setComprimento(rs.getInt("comprimento"));
                    embarcacao.setIdUtilizador(rs.getInt("idUtilizador"));
                    embarcacao.setIdMarina(rs.getInt("idMarina"));
                }
            }
        }
        return embarcacao;
    }

    public Embarcacao updateEmbarcacao(Embarcacao embarcacao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, embarcacao.getNome());
            pstmt.setInt(2, embarcacao.getComprimento());
            pstmt.setInt(3, embarcacao.getIdUtilizador());
            pstmt.setInt(4, embarcacao.getIdMarina());
            pstmt.executeUpdate();
            pstmt.executeUpdate();
        }
        return embarcacao;
    }

    public void deleteEmbarcacao(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
