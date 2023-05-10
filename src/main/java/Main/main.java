package Main;

import Agendamento.AgendamentoService;
import CodPostal.CodPostal;
import CodPostal.CodPostalService;

import Embarcacao.EmbarcacaoService;
import PedidoDescricao.PedidoDescricaoService;
import TipoUtilizador.TipoUtilizador;
import TipoUtilizador.TipoUtilizadorService;
import Utilizador.*;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args){
        AgendamentoService agendamentoService = new AgendamentoService();
        System.out.println(agendamentoService.getAgendamentoById(66).getData());
    }
}
