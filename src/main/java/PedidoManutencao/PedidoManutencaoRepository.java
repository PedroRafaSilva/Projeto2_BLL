package PedidoManutencao;

import projeto2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoManutencaoRepository {

    private static final String SELECT_ALL = "SELECT * FROM \"Projecto1\".\"PedidoManutencao\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"Projecto1\".\"PedidoManutencao\" WHERE \"idPedido\" = ?";
    private static final String INSERT = "INSERT INTO \"Projecto1\".\"PedidoManutencao\" (data, \"valor\", descricao, \"idEmbarcacao\", \"idOficina\", \"idUtilizador\", \"idFatura\") VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE \"Projecto1\".\"PedidoManutencao\" SET data = ?, \"valor\" = ?, descricao = ?, \"idEmbarcacao\" = ?, \"idOficina\" = ?, \"idUtilizador\" = ?, \"idFatura\" = ? WHERE \"idPedido\" = ?";
    private static final String DELETE = "DELETE FROM \"Projecto1\".\"PedidoManutencao\" WHERE \"idPedido\"= ?";

    public List<PedidoManutencao> getAllPedidoManutencaos() throws SQLException {
        List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                PedidoManutencao pedidoManutencao = new PedidoManutencao();
                pedidoManutencao.setData(rs.getDate("data"));
                pedidoManutencao.setValor(rs.getFloat("valor"));
                pedidoManutencao.setDescricao(rs.getString("descricao"));
                pedidoManutencao.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                pedidoManutencao.setIdOficina(rs.getInt("idOficina"));
                pedidoManutencao.setIdUtilizador(rs.getInt("idUtilizador"));
                pedidoManutencao.setIdFatura(rs.getInt("idFatura"));
                pedidoManutencaos.add(pedidoManutencao);
            }
        }
        return pedidoManutencaos;
    }

    public PedidoManutencao savePedidoManutencao(PedidoManutencao pedidoManutencao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, pedidoManutencao.getData());
            pstmt.setFloat(2, pedidoManutencao.getValor());
            pstmt.setString(3, pedidoManutencao.getDescricao());
            pstmt.setInt(4, pedidoManutencao.getIdEmbarcacao());
            pstmt.setInt(5, pedidoManutencao.getIdOficina());
            pstmt.setInt(6, pedidoManutencao.getIdUtilizador());
            pstmt.setInt(7, pedidoManutencao.getIdFatura());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pedidoManutencao.setIdPedido(rs.getInt(1));
                }
            }
        }
        return pedidoManutencao;
    }

    public PedidoManutencao findPedidoManutencaoById(int id) throws SQLException {
        PedidoManutencao pedidoManutencao = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pedidoManutencao = new PedidoManutencao();
                    pedidoManutencao.setData(rs.getDate("data"));
                    pedidoManutencao.setValor(rs.getFloat("valor"));
                    pedidoManutencao.setDescricao(rs.getString("descricao"));
                    pedidoManutencao.setIdEmbarcacao(rs.getInt("idEmbarcacao"));
                    pedidoManutencao.setIdOficina(rs.getInt("idOficina"));
                    pedidoManutencao.setIdUtilizador(rs.getInt("idUtilizador"));
                    pedidoManutencao.setIdFatura(rs.getInt("idFatura"));
                }
            }
        }
        return pedidoManutencao;
    }

    public PedidoManutencao updatePedidoManutencao(PedidoManutencao pedidoManutencao) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setDate(1, pedidoManutencao.getData());
            pstmt.setFloat(2, pedidoManutencao.getValor());
            pstmt.setString(3, pedidoManutencao.getDescricao());
            pstmt.setInt(4, pedidoManutencao.getIdEmbarcacao());
            pstmt.setInt(5, pedidoManutencao.getIdOficina());
            pstmt.setInt(6, pedidoManutencao.getIdUtilizador());
            pstmt.setInt(7, pedidoManutencao.getIdFatura());
            pstmt.executeUpdate();
        }
        return pedidoManutencao;
    }

    public void deletePedidoManutencao(int id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

