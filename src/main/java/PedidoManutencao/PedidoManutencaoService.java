package PedidoManutencao;

import java.util.List;

public class PedidoManutencaoService {

    private PedidoManutencaoRepository pedidoManutencaoRepository = new PedidoManutencaoRepository();

    public List<PedidoManutencao> getAllPedidoManutencaos() {
        return pedidoManutencaoRepository.getAllPedidoManutencaos();
    }

    public void createPedidoManutencao(PedidoManutencao pedidoManutencao) {
        pedidoManutencaoRepository.createPedidoManutencao(pedidoManutencao);
    }

    public PedidoManutencao getPedidoManutencaoById(int id) {
        return pedidoManutencaoRepository.getPedidoManutencaoById(id);
    }

    public void updatePedidoManutencao(PedidoManutencao pedidoManutencao) {
        pedidoManutencaoRepository.updatePedidoManutencao(pedidoManutencao);
    }

    public void deletePedidoManutencao(int id) {
        pedidoManutencaoRepository.deletePedidoManutencao(id);
    }
}

