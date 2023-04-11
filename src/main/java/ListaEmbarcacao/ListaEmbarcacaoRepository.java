package ListaEmbarcacao;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEmbarcacaoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"ListaEmbarcacao\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"ListaEmbarcacao\" WHERE \"idFatura\" = ? AND \"idEmbarcacao\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"ListaEmbarcacao\" (\"idAgendamento\", \"idExtra\", \"valorPagar\") VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"ListaEmbarcacao\" SET \"idAgendamento\" = ?, \"idExtra\" = ?, \"valorPagar\" = ? WHERE \"idFatura\" = ? AND \"idEmbarcacao\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"ListaEmbarcacao\" WHERE \"idFatura\" = ? AND \"idEmbarcacao\" = ?";

    public List<ListaEmbarcacao> getAllListaEmbarcacaos() throws SQLException {
        List<ListaEmbarcacao> listaEmbarcacaos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                ListaEmbarcacao listaEmbarcacao = new ListaEmbarcacao();
                listaEmbarcacao.setIdFatura(rs.getInt("idFatura"));
                listaEmbarcacao.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                listaEmbarcacao.setValorPagar(rs.getFloat("valorPagar"));
                listaEmbarcacaos.add(listaEmbarcacao);
            }
        }
        return listaEmbarcacaos;
    }

    public ListaEmbarcacao saveListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, listaEmbarcacao.getIdFatura());
            pstmt.setInt(2, listaEmbarcacao.getIdEmbarcacao());
            pstmt.setFloat(3, listaEmbarcacao.getValorPagar());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    listaEmbarcacao.setIdFatura(rs.getInt(1));
                    listaEmbarcacao.setIdEmbarcacao(rs.getInt(2));
                }
            }
        }
        return listaEmbarcacao;
    }

    public ListaEmbarcacao findListaEmbarcacaoByIds(int id, int id2) throws SQLException {
        ListaEmbarcacao listaEmbarcacao = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id2);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    listaEmbarcacao = new ListaEmbarcacao();
                    listaEmbarcacao.setIdFatura(rs.getInt("idFatura"));
                    listaEmbarcacao.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                    listaEmbarcacao.setValorPagar(rs.getFloat("valorPagar"));
                }
            }
        }
        return listaEmbarcacao;
    }

    public ListaEmbarcacao updateListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, listaEmbarcacao.getIdFatura());
            pstmt.setInt(2, listaEmbarcacao.getIdEmbarcacao());
            pstmt.setFloat(3, listaEmbarcacao.getValorPagar());
            pstmt.executeUpdate();
        }
        return listaEmbarcacao;
    }

    public void deleteListaEmbarcacao(int id, int id2) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.setInt(1, id2);
            pstmt.executeUpdate();
        }
    }
}
