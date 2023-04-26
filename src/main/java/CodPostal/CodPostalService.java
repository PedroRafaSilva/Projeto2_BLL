package CodPostal;

import java.util.List;

public class CodPostalService {

    private CodPostalRepository codPostalRepository = new CodPostalRepository();

    public List<CodPostal> getAllCodPostals() {
        return codPostalRepository.getAllCodPostals();
    }

    public void createCodPostal(CodPostal codPostal) {
        codPostalRepository.createCodPostal(codPostal);
    }

    public CodPostal getCodPostalById(String id) {
        return codPostalRepository.getCodPostalById(id);
    }

    public void updateCodPostal(CodPostal codPostal) {
        codPostalRepository.updateCodPostal(codPostal);
    }

    public void deleteCodPostal(String id) {
        codPostalRepository.deleteCodPostal(id);
    }
}

