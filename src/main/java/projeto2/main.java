package projeto2;

import AgendamentoExtra.AgendamentoExtraService;
import CodPostal.CodPostalRepository;
import Embarcacao.EmbarcacaoService;
import EstadoAgendamento.EstadoAgendamento;
import EstadoAgendamento.EstadoAgendamentoRepository;
import Marina.MarinaService;
import Utilizador.Utilizador.*;
import Utilizador.UtilizadorService;


import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args){
        MarinaService marinaService = new MarinaService();
        marinaService.getAllMarinas();

    }
}
