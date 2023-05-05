package Agendamento;

import java.sql.Date;
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

    public List<Agendamento> getAgendamentosByDate(int dia, int mes, int ano) {
        return agendamentoRepository.findAllAgendamentosByDate(dia, mes, ano);
    }

    public boolean checkClienteAgenAt(int id, Date date){
        return agendamentoRepository.checkClienteAgendamentoAt(id, date);
    }

    public Agendamento findMostRecentAgendamento(){ return agendamentoRepository.findMostRecentAgendamento();}
}

