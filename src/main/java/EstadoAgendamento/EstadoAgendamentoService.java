package EstadoAgendamento;

import java.util.List;

public class EstadoAgendamentoService {

    private EstadoAgendamentoRepository estadoAgendamentoRepository = new EstadoAgendamentoRepository();

    public List<EstadoAgendamento> getAllEstadoAgendamentos() {
        return estadoAgendamentoRepository.getAllEstadoAgendamentos();
    }

    public void createEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        estadoAgendamentoRepository.createEstadoAgendamento(estadoAgendamento);
    }

    public EstadoAgendamento getEstadoAgendamentoById(int id) {
        return estadoAgendamentoRepository.getEstadoAgendamentoById(id);
    }

    public void updateEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        estadoAgendamentoRepository.updateEstadoAgendamento(estadoAgendamento);
    }

    public void deleteEstadoAgendamento(int id) {
        estadoAgendamentoRepository.deleteEstadoAgendamento(id);
    }
}

