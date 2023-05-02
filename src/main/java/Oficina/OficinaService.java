package Oficina;

import java.util.List;

public class OficinaService {

    private OficinaRepository oficinaRepository = new OficinaRepository();

    public List<Oficina> getAllOficinas() {
        return oficinaRepository.getAllOficinas();
    }

    public void createOficina(Oficina oficina) {
        oficinaRepository.createOficina(oficina);
    }

    public Oficina getOficinaById(int id) {
        return oficinaRepository.getOficinaById(id);
    }

    public void updateOficina(Oficina oficina) {
        oficinaRepository.updateOficina(oficina);
    }

    public void deleteOficina(int id) {
        oficinaRepository.deleteOficina(id);
    }

    public List<Oficina> getOficinasComPrefix(String prefix){
        return oficinaRepository.getOficinasComPrefix(prefix);
    }
}

