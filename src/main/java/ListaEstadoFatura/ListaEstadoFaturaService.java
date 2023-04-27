package ListaEstadoFatura;

import java.util.List;

public class ListaEstadoFaturaService {

    private ListaEstadoFaturaRepository listaEstadoFaturaRepository = new ListaEstadoFaturaRepository();

    public List<ListaEstadoFatura> getAllListaEstadoFaturas() {
        return listaEstadoFaturaRepository.getAllListaEstadoFaturas();
    }

    public void createListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        listaEstadoFaturaRepository.createListaEstadoFatura(listaEstadoFatura);
    }

    public ListaEstadoFatura getListaEstadoFaturaById(int id, int id2) {
        return listaEstadoFaturaRepository.getListaEstadoFaturaById(id, id2);
    }

    public void updateListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        listaEstadoFaturaRepository.updateListaEstadoFatura(listaEstadoFatura);
    }

    public void deleteListaEstadoFatura(int id, int id2) {
        listaEstadoFaturaRepository.deleteListaEstadoFatura(id, id2);
    }
}

