package projeto2;

import PedidoManutencao.PedidoManutencaoRepository;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        PedidoManutencaoRepository pedidoManutencaoRepository = new PedidoManutencaoRepository();
        try {
            System.out.println(pedidoManutencaoRepository.findPedidoManutencaoById(1).getDescricao());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
