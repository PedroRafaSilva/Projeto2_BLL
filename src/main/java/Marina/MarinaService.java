package Marina;

import java.util.List;

public class MarinaService {

    private MarinaRepository marinaRepository = new MarinaRepository();

    public List<Marina> getAllMarinas() {
        return marinaRepository.getAllMarinas();
    }

    public void createMarina(Marina marina) {
        marinaRepository.createMarina(marina);
    }

    public Marina getMarinaById(int id) {
        return marinaRepository.getMarinaById(id);
    }

    public void updateMarina(Marina marina) {
        marinaRepository.updateMarina(marina);
    }

    public void deleteMarina(int id) {
        marinaRepository.deleteMarina(id);
    }

    public List<Marina> getMarinasComPrefix(String prefix){return marinaRepository.getMarinasComPrefix(prefix);}

    public Marina getMarinaByName(String name){return marinaRepository.findMarinaByName(name);}
}

