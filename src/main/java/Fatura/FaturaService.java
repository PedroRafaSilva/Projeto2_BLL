package Fatura;

import java.util.List;

public class FaturaService {

    private FaturaRepository faturaRepository = new FaturaRepository();

    public List<Fatura> getAllFaturas() {
        return faturaRepository.getAllFaturas();
    }

    public void createFatura(Fatura fatura) {
        faturaRepository.createFatura(fatura);
    }

    public Fatura getFaturaById(int id) {
        return faturaRepository.getFaturaById(id);
    }

    public void updateFatura(Fatura fatura) {
        faturaRepository.updateFatura(fatura);
    }

    public void deleteFatura(int id) {
        faturaRepository.deleteFatura(id);
    }

    public Fatura getFaturaOfMothFromCliente(int idCliente, int month){ return faturaRepository.getFaturaOfMothFromCliente(idCliente, month);}

    public boolean checkFaturaOfMothFromCliente(int idCliente, int month){ return faturaRepository.checkFaturaOfMothFromCliente(idCliente, month);}
}

