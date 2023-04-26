package Comprimento;

import java.util.List;

public class ComprimentoService {

    private ComprimentoRepository comprimentoRepository = new ComprimentoRepository();

    public List<Comprimento> getAllComprimentos() {
        return comprimentoRepository.getAllComprimentos();
    }

    public void createComprimento(Comprimento comprimento) {
        comprimentoRepository.createComprimento(comprimento);
    }

    public Comprimento getComprimentoById(String id) {
        return comprimentoRepository.getComprimentoById(id);
    }

    public void updateComprimento(Comprimento comprimento) {
        comprimentoRepository.updateComprimento(comprimento);
    }

    public void deleteComprimento(String id) {
        comprimentoRepository.deleteComprimento(id);
    }
}

