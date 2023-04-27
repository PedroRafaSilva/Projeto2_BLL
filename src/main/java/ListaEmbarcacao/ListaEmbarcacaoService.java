package ListaEmbarcacao;

import java.util.List;

public class ListaEmbarcacaoService {

    private ListaEmbarcacaoRepository listaEmbarcacaoRepository = new ListaEmbarcacaoRepository();

    public List<ListaEmbarcacao> getAllListaEmbarcacaos() {
        return listaEmbarcacaoRepository.getAllListaEmbarcacaos();
    }

    public void createListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        listaEmbarcacaoRepository.createListaEmbarcacao(listaEmbarcacao);
    }

    public ListaEmbarcacao getListaEmbarcacaoById(int id, int id2) {
        return listaEmbarcacaoRepository.getListaEmbarcacaoById(id, id2);
    }

    public void updateListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        listaEmbarcacaoRepository.updateListaEmbarcacao(listaEmbarcacao);
    }

    public void deleteListaEmbarcacao(int id, int id2) {
        listaEmbarcacaoRepository.deleteListaEmbarcacao(id, id2);
    }
}

