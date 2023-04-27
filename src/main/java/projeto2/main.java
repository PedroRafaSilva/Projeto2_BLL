package projeto2;

import AgendamentoExtra.AgendamentoExtraService;
import CodPostal.CodPostalRepository;
import Embarcacao.EmbarcacaoService;
import EstadoAgendamento.EstadoAgendamentoService;
import EstadoPagamento.EstadoPagamentoService;
import Extra.ExtraService;
import Fatura.FaturaService;
import ListaEmbarcacao.ListaEmbarcacaoService;
import ListaEstadoAgendamento.ListaEstadoAgendamentoService;
import ListaEstadoFatura.ListaEstadoFaturaService;
import Marina.MarinaService;
import Oficina.OficinaService;
import Utilizador.Utilizador.*;
import Utilizador.UtilizadorService;


import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args){
        OficinaService oficinaService = new OficinaService();
        oficinaService.getAllOficinas();

    }
}
