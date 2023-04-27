package ListaEstadoAgendamento;

import java.util.List;

public class ListaEstadoAgendamentoService {

    private ListaEstadoAgendamentoRepository listaEstadoAgendamentoRepository = new ListaEstadoAgendamentoRepository();

    public List<ListaEstadoAgendamento> getAllListaEstadoAgendamentos() {
        return listaEstadoAgendamentoRepository.getAllListaEstadoAgendamentos();
    }

    public void createListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        listaEstadoAgendamentoRepository.createListaEstadoAgendamento(listaEstadoAgendamento);
    }

    public ListaEstadoAgendamento getListaEstadoAgendamentoById(int id, int id2) {
        return listaEstadoAgendamentoRepository.getListaEstadoAgendamentoById(id, id2);
    }

    public void updateListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        listaEstadoAgendamentoRepository.updateListaEstadoAgendamento(listaEstadoAgendamento);
    }

    public void deleteListaEstadoAgendamento(int id, int id2) {
        listaEstadoAgendamentoRepository.deleteListaEstadoAgendamento(id, id2);
    }
}

