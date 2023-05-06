package AgendamentoExtra;

import java.util.List;

public class AgendamentoExtraService {

    private AgendamentoExtraRepository agendamentoExtraRepository = new AgendamentoExtraRepository();

    public List<AgendamentoExtra> getAllAgendamentoExtras() {
        return agendamentoExtraRepository.getAllAgendamentoExtras();
    }

    public List<AgendamentoExtra> findAgendamentoExtraByIdAgendamento(int idAgendamento){
        return agendamentoExtraRepository.findAgendamentoExtraByIdAgendamento(idAgendamento);
    }

    public void createAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        agendamentoExtraRepository.createAgendamentoExtra(agendamentoExtra);
    }

    public AgendamentoExtra getAgendamentoExtraById(int id, int id2) {
        return agendamentoExtraRepository.getAgendamentoExtraById(id, id2);
    }

    public void updateAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        agendamentoExtraRepository.updateAgendamentoExtra(agendamentoExtra);
    }

    public void deleteAgendamentoExtra(int id, int id2) {
        agendamentoExtraRepository.deleteAgendamentoExtra(id, id2);
    }
}

