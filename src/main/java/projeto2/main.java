package projeto2;

import EstadoAgendamento.EstadoAgendamento;
import EstadoAgendamento.EstadoAgendamentoRepository;
import Utilizador.Utilizador.*;
import Utilizador.UtilizadorService;


import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args){
       UtilizadorService utilizadorRepository = new UtilizadorService();
       System.out.println(utilizadorRepository.isUserAlreadyRegistered("Pedro", "Pedro"));

    }
}
