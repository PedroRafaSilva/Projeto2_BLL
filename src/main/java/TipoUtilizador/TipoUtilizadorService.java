package TipoUtilizador;

import java.util.List;

public class TipoUtilizadorService {

    private TipoUtilizadorRepository tipoUtilizadorRepository = new TipoUtilizadorRepository();

    public List<TipoUtilizador> getAllTipoUtilizadors() {
        return tipoUtilizadorRepository.getAllTipoUtilizadors();
    }

    public void createTipoUtilizador(TipoUtilizador tipoUtilizador) {
        tipoUtilizadorRepository.createTipoUtilizador(tipoUtilizador);
    }

    public TipoUtilizador getTipoUtilizadorById(int id) {
        return tipoUtilizadorRepository.getTipoUtilizadorById(id);
    }

    public void updateTipoUtilizador(TipoUtilizador tipoUtilizador) {
        tipoUtilizadorRepository.updateTipoUtilizador(tipoUtilizador);
    }

    public void deleteTipoUtilizador(int id) {
        tipoUtilizadorRepository.deleteTipoUtilizador(id);
    }
}

