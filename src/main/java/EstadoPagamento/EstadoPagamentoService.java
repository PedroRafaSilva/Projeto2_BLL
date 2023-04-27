package EstadoPagamento;

import java.util.List;

public class EstadoPagamentoService {

    private EstadoPagamentoRepository estadoPagamentoRepository = new EstadoPagamentoRepository();

    public List<EstadoPagamento> getAllEstadoPagamentos() {
        return estadoPagamentoRepository.getAllEstadoPagamentos();
    }

    public void createEstadoPagamento(EstadoPagamento estadoPagamento) {
        estadoPagamentoRepository.createEstadoPagamento(estadoPagamento);
    }

    public EstadoPagamento getEstadoPagamentoById(int id) {
        return estadoPagamentoRepository.getEstadoPagamentoById(id);
    }

    public void updateEstadoPagamento(EstadoPagamento estadoPagamento) {
        estadoPagamentoRepository.updateEstadoPagamento(estadoPagamento);
    }

    public void deleteEstadoPagamento(int id) {
        estadoPagamentoRepository.deleteEstadoPagamento(id);
    }
}

