package PedidoManutencao;

import Agendamento.Agendamento;

import java.sql.Date;
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

    public List<PedidoManutencao> getPedidosByDate(int dia, int mes, int ano) {
        return pedidoManutencaoRepository.findAllPedidossByDate(dia, mes, ano);
    }

    public boolean checkPedidoEmbarcacaoAt(int id, Date date){
        return pedidoManutencaoRepository.checkPedidoEmbarcacaooAt(id, date);
    }
}

