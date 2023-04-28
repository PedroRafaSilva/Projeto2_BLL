package Pagamento;

import java.util.List;

public class PagamentoService {

    private PagamentoRepository pagamentoRepository = new PagamentoRepository();

    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.getAllPagamentos();
    }

    public void createPagamento(Pagamento pagamento) {
        pagamentoRepository.createPagamento(pagamento);
    }

    public Pagamento getPagamentoById(int id) {
        return pagamentoRepository.getPagamentoById(id);
    }

    public void updatePagamento(Pagamento pagamento) {
        pagamentoRepository.updatePagamento(pagamento);
    }

    public void deletePagamento(int id) {
        pagamentoRepository.deletePagamento(id);
    }
}

