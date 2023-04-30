package Main;

import CodPostal.CodPostal;
import CodPostal.CodPostalService;
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
        CodPostalService codPostalService = new CodPostalService();
        CodPostal codPostal = new CodPostal();
        System.out.println(codPostal.getCpostal());
        codPostalService.updateCodPostal(codPostal);
    }
}
