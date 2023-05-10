package PedidoDescricao;

import PedidoDescricao.PedidoDescricao;
import PedidoDescricao.PedidoDescricaoRepository;

import java.util.List;

public class PedidoDescricaoService {

    private PedidoDescricaoRepository pedidoDescricaoRepository = new PedidoDescricaoRepository();

    public List<PedidoDescricao> getAllPedidoDescricaos() {
        return pedidoDescricaoRepository.getAllPedidoDescricaos();
    }

    public void createPedidoDescricao(PedidoDescricao pedidoDescricao) {
        pedidoDescricaoRepository.createPedidoDescricao(pedidoDescricao);
    }

    public PedidoDescricao getPedidoDescricaoById(String id) {
        return pedidoDescricaoRepository.getPedidoDescricaoById(id);
    }

    public void updatePedidoDescricao(PedidoDescricao pedidoDescricao) {
        pedidoDescricaoRepository.updatePedidoDescricao(pedidoDescricao);
    }

    public void deletePedidoDescricao(String id) {
        pedidoDescricaoRepository.deletePedidoDescricao(id);
    }

}
