package Embarcacao;

import Agendamento.Agendamento;
import Comprimento.Comprimento;
import ListaEmbarcacao.ListaEmbarcacao;
import Marina.Marina;
import PedidoManutencao.PedidoManutencao;
import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"Embarcacao\"")
public class Embarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmbarcacao")
    private int idEmbarcacao;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic
    @Column(name = "idMarina")
    private Integer idMarina;

    @Basic
    @Column(name = "comprimento")
    private Integer comprimento;

    @OneToMany(mappedBy = "embarcacao", cascade = CascadeType.REMOVE)
    @OrderBy("data")
    private List<Agendamento> agendamentoes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "comprimento", updatable = false, insertable = false)
    private Comprimento descComprimento;

    @ManyToOne
    @JoinColumn(name = "idutilizador", updatable = false, insertable = false)
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(name = "idmarina", updatable = false, insertable = false)
    private Marina marina;

    @OneToMany(mappedBy = "embarcacao", cascade = CascadeType.REMOVE)
    private List<ListaEmbarcacao> listaEmbarcacaos = new ArrayList<>();

    @OneToMany(mappedBy = "embarcacao", cascade = CascadeType.REMOVE)
    private List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

    public List<PedidoManutencao> getPedidoManutencaos() {
        return pedidoManutencaos;
    }

    public void setPedidoManutencaos(List<PedidoManutencao> pedidoManutencaos) {
        this.pedidoManutencaos = pedidoManutencaos;
    }

    public List<ListaEmbarcacao> getListaEmbarcacaos() {
        return listaEmbarcacaos;
    }

    public void setListaEmbarcacaos(List<ListaEmbarcacao> listaEmbarcacaos) {
        this.listaEmbarcacaos = listaEmbarcacaos;
    }

    public List<Agendamento> getAgendamentoes() {
        return agendamentoes;
    }

    public void setAgendamentoes(List<Agendamento> agendamentoes) {
        this.agendamentoes = agendamentoes;
    }

    public Marina getmarina() {
        return marina;
    }

    public void setmarina(Marina idmarina) {
        this.marina = idmarina;
    }

    public Utilizador getutilizador() {
        return utilizador;
    }

    public void setutilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Comprimento getDescComprimento() {
        return descComprimento;
    }

    public void setDescComprimento(Comprimento descomprimento) {
        this.descComprimento = descomprimento;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    public int getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(int idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdMarina() {
        return idMarina;
    }

    public void setIdMarina(Integer idMarina) {
        this.idMarina = idMarina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Embarcacao that = (Embarcacao) o;

        if (idEmbarcacao != that.idEmbarcacao) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (idUtilizador != null ? !idUtilizador.equals(that.idUtilizador) : that.idUtilizador != null) return false;
        if (idMarina != null ? !idMarina.equals(that.idMarina) : that.idMarina != null) return false;
        if (comprimento != null ? !comprimento.equals(that.comprimento) : that.comprimento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmbarcacao;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        result = 31 * result + (idMarina != null ? idMarina.hashCode() : 0);
        result = 31 * result + (comprimento != null ? comprimento.hashCode() : 0);
        return result;
    }
}
