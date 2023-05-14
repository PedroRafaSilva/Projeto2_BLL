package Fatura;

import ListaEmbarcacao.ListaEmbarcacao;
import ListaEstadoFatura.ListaEstadoFatura;
import Pagamento.Pagamento;
import PedidoManutencao.PedidoManutencao;
import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"Fatura\"")
public class Fatura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfatura")
    private int idfatura;
    @Basic
    @Column(name = "datacriacao")
    private Date datacriacao;
    @Basic
    @Column(name = "prazo")
    private Date prazo;
    @Basic
    @Column(name = "valorembarcacoes")
    private Float valorembarcacoes;
    @Basic
    @Column(name = "valoragendamento")
    private Float valoragendamento;
    @Basic
    @Column(name = "valormanutencao")
    private Float valormanutencao;
    @Basic
    @Column(name = "valortotal")
    private Float valortotal;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "numfiscal")
    private Integer numfiscal;

    @OneToMany(mappedBy = "fatura", cascade = CascadeType.REMOVE)
    private List<ListaEmbarcacao> listaEmbarcacaos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idutilizador", updatable = false, insertable = false)
    private Utilizador utilizador;

    @OneToMany(mappedBy = "fatura", cascade = CascadeType.REMOVE)
    private List<ListaEstadoFatura> listaEstadoFaturas = new ArrayList<>();

    @OneToMany(mappedBy = "fatura", cascade = CascadeType.REMOVE)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @OneToMany(mappedBy = "fatura", cascade = CascadeType.REMOVE)
    private List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

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

    public List<ListaEstadoFatura> getListaEstadoFaturas() {
        return listaEstadoFaturas;
    }

    public void setListaEstadoFaturas(List<ListaEstadoFatura> listaEstadoFaturas) {
        this.listaEstadoFaturas = listaEstadoFaturas;
    }

    public List<ListaEmbarcacao> getListaEmbarcacaos() {
        return listaEmbarcacaos;
    }

    public void setListaEmbarcacaos(List<ListaEmbarcacao> listaEmbarcacaos) {
        this.listaEmbarcacaos = listaEmbarcacaos;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Float getValorembarcacoes() {
        return valorembarcacoes;
    }

    public void setValorembarcacoes(Float valorembarcacoes) {
        this.valorembarcacoes = valorembarcacoes;
    }

    public Float getValoragendamento() {
        return valoragendamento;
    }

    public void setValoragendamento(Float valoragendamento) {
        this.valoragendamento = valoragendamento;
    }

    public Float getValormanutencao() {
        return valormanutencao;
    }

    public void setValormanutencao(Float valormanutencao) {
        this.valormanutencao = valormanutencao;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    public Integer getNumfiscal() {
        return numfiscal;
    }

    public void setNumfiscal(Integer numfiscal) {
        this.numfiscal = numfiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fatura fatura = (Fatura) o;

        if (idfatura != fatura.idfatura) return false;
        if (datacriacao != null ? !datacriacao.equals(fatura.datacriacao) : fatura.datacriacao != null) return false;
        if (prazo != null ? !prazo.equals(fatura.prazo) : fatura.prazo != null) return false;
        if (valorembarcacoes != null ? !valorembarcacoes.equals(fatura.valorembarcacoes) : fatura.valorembarcacoes != null)
            return false;
        if (valoragendamento != null ? !valoragendamento.equals(fatura.valoragendamento) : fatura.valoragendamento != null)
            return false;
        if (valormanutencao != null ? !valormanutencao.equals(fatura.valormanutencao) : fatura.valormanutencao != null)
            return false;
        if (valortotal != null ? !valortotal.equals(fatura.valortotal) : fatura.valortotal != null) return false;
        if (idutilizador != null ? !idutilizador.equals(fatura.idutilizador) : fatura.idutilizador != null)
            return false;
        if (numfiscal != null ? !numfiscal.equals(fatura.numfiscal) : fatura.numfiscal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + (datacriacao != null ? datacriacao.hashCode() : 0);
        result = 31 * result + (prazo != null ? prazo.hashCode() : 0);
        result = 31 * result + (valorembarcacoes != null ? valorembarcacoes.hashCode() : 0);
        result = 31 * result + (valoragendamento != null ? valoragendamento.hashCode() : 0);
        result = 31 * result + (valormanutencao != null ? valormanutencao.hashCode() : 0);
        result = 31 * result + (valortotal != null ? valortotal.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (numfiscal != null ? numfiscal.hashCode() : 0);
        return result;
    }
}
