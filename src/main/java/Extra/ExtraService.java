package Extra;

import java.util.List;

public class ExtraService {

    private ExtraRepository extraRepository = new ExtraRepository();

    public List<Extra> getAllExtras() {
        return extraRepository.getAllExtras();
    }

    public void createExtra(Extra extra) {
        extraRepository.createExtra(extra);
    }

    public Extra getExtraById(int id) {
        return extraRepository.getExtraById(id);
    }

    public void updateExtra(Extra extra) {
        extraRepository.updateExtra(extra);
    }

    public void deleteExtra(int id) {
        extraRepository.deleteExtra(id);
    }
}

