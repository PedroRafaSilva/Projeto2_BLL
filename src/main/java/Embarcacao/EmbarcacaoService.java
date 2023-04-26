package Embarcacao;

import java.util.List;

public class EmbarcacaoService {

    private EmbarcacaoRepository embarcacaoRepository = new EmbarcacaoRepository();

    public List<Embarcacao> getAllEmbarcacaos() {
        return embarcacaoRepository.getAllEmbarcacaos();
    }

    public void createEmbarcacao(Embarcacao embarcacao) {
        embarcacaoRepository.createEmbarcacao(embarcacao);
    }

    public Embarcacao getEmbarcacaoById(int id) {
        return embarcacaoRepository.getEmbarcacaoById(id);
    }

    public void updateEmbarcacao(Embarcacao embarcacao) {
        embarcacaoRepository.updateEmbarcacao(embarcacao);
    }

    public void deleteEmbarcacao(int id) {
        embarcacaoRepository.deleteEmbarcacao(id);
    }
}

