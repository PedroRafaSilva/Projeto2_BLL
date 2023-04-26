package Agendamento;

import java.util.List;

public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository = new AgendamentoRepository();

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.getAllAgendamentos();
    }

    public void createAgendamento(Agendamento agendamento) {
        agendamentoRepository.createAgendamento(agendamento);
    }

    public Agendamento getAgendamentoById(int id) {
        return agendamentoRepository.getAgendamentoById(id);
    }

    public void updateAgendamento(Agendamento agendamento) {
        agendamentoRepository.updateAgendamento(agendamento);
    }

    public void deleteAgendamento(int id) {
        agendamentoRepository.deleteAgendamento(id);
    }
}

