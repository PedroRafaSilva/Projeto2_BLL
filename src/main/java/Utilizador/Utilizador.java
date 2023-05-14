package Utilizador;

import Agendamento.Agendamento;
import CodPostal.CodPostal;
import Embarcacao.Embarcacao;
import Fatura.Fatura;
import Pagamento.Pagamento;
import PedidoManutencao.PedidoManutencao;
import TipoUtilizador.TipoUtilizador;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"Utilizador\"")
public class Utilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idutilizador")
    private int idutilizador;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "telefone")
    private String telefone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nif")
    private Integer nif;
    @Basic
    @Column(name = "rua")
    private String rua;
    @Basic
    @Column(name = "porta")
    private Integer porta;
    @Basic
    @Column(name = "idtipoutilizador")
    private Integer idtipoutilizador;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "cpostal")
    private String cPostal;



    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.REMOVE)
    @OrderBy("data")
    private List<Agendamento> agendamentoes = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.REMOVE)
    @OrderBy("nome")
    private List<Embarcacao> embarcacaos = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.REMOVE)
    private List<Fatura> faturas = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.REMOVE)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.REMOVE)
    private List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idtipoutilizador", updatable = false, insertable = false)
    private TipoUtilizador tipoUtilizador;

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }

    public List<PedidoManutencao> getPedidoManutencaos() {
        return pedidoManutencaos;
    }

    public void setPedidoManutencaos(List<PedidoManutencao> pedidoManutencaos) {
        this.pedidoManutencaos = pedidoManutencaos;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }

    public List<Embarcacao> getEmbarcacaos() {
        return embarcacaos;
    }

    public void setEmbarcacaos(List<Embarcacao> embarcacaos) {
        this.embarcacaos = embarcacaos;
    }

    public List<Agendamento> getAgendamentoes() {
        return agendamentoes;
    }

    public void setAgendamentoes(List<Agendamento> agendamentoes) {
        this.agendamentoes = agendamentoes;
    }

    public String getcPostal() {
        return cPostal;
    }

    public void setcPostal(String cPostal) {
        this.cPostal = cPostal;
    }

    public int getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(int idutilizador) {
        this.idutilizador = idutilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }


    public Integer getIdtipoutilizador() {
        return idtipoutilizador;
    }

    public void setIdtipoutilizador(Integer idtipoutilizador) {
        this.idtipoutilizador = idtipoutilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilizador that = (Utilizador) o;

        if (idutilizador != that.idutilizador) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (porta != null ? !porta.equals(that.porta) : that.porta != null) return false;
        if (idtipoutilizador != null ? !idtipoutilizador.equals(that.idtipoutilizador) : that.idtipoutilizador != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idutilizador;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (porta != null ? porta.hashCode() : 0);
        result = 31 * result + (idtipoutilizador != null ? idtipoutilizador.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
