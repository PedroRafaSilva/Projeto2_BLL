package Utilizador;

import java.util.List;

public class UtilizadorService {

    UtilizadorRepository utilizadorRepository = new UtilizadorRepository();
    public List<Utilizador> getAllUtilizadores() {
        return utilizadorRepository.getAllUtilizadores();
    }

    public List<Utilizador> getAllUtilizadoresOrderByName() {
        return utilizadorRepository.getAllUtilizadoresOrderByName();
    }

    public List<Utilizador> getAllClientes() {
        return utilizadorRepository.getAllClientes();
    }

    public List<Utilizador> getAllFuncionarios() {
        return utilizadorRepository.getAllFuncionarios();
    }

    public void createUtilizador(Utilizador utilizador) {
        utilizadorRepository.createUtilizador(utilizador);
    }

    public Utilizador getUtilizadorById(int id) {
        return utilizadorRepository.getUtilizadorById(id);
    }

    public void updateUtilizador(Utilizador utilizador) {
        utilizadorRepository.updateUtilizador(utilizador);
    }

    public void deleteUtilizador(int id) {
        utilizadorRepository.deleteUtilizador(id);
    }

    public boolean isUserAlreadyRegistered(String username, String password) {
        return utilizadorRepository.isUserAlreadyRegistered(username, password);
    }

    public Utilizador getUtilizadorByNome(String nome){
        return utilizadorRepository.findByName(nome);
    }

}
