package Main;

import TipoUtilizador.TipoUtilizadorService;

public class main {
    public static void main(String[] args){
        TipoUtilizadorService tipoUtilizadorService = new TipoUtilizadorService();
        System.out.println(tipoUtilizadorService.getAllTipoUtilizadors());

    }
}
