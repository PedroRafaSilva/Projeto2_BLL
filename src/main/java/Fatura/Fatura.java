package Fatura;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Fatura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFatura")
    private int idFatura;
    @Basic
    @Column(name = "dataCriacao")
    private Date dataCriacao;
    @Basic
    @Column(name = "prazo")
    private Date prazo;
    @Basic
    @Column(name = "valorEmbarcacoes")
    private Float valorEmbarcacoes;
    @Basic
    @Column(name = "valorAgendamento")
    private Float valorAgendamento;
    @Basic
    @Column(name = "valorManutencao")
    private Float valorManutencao;
    @Basic
    @Column(name = "valorTotal")
    private Float valorTotal;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic
    @Column(name = "numFiscal")
    private Integer numFiscal;

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Float getValorEmbarcacoes() {
        return valorEmbarcacoes;
    }

    public void setValorEmbarcacoes(Float valorEmbarcacoes) {
        this.valorEmbarcacoes = valorEmbarcacoes;
    }

    public Float getValorAgendamento() {
        return valorAgendamento;
    }

    public void setValorAgendamento(Float valorAgendamento) {
        this.valorAgendamento = valorAgendamento;
    }

    public Float getValorManutencao() {
        return valorManutencao;
    }

    public void setValorManutencao(Float valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getNumFiscal() {
        return numFiscal;
    }

    public void setNumFiscal(Integer numFiscal) {
        this.numFiscal = numFiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fatura fatura = (Fatura) o;

        if (idFatura != fatura.idFatura) return false;
        if (dataCriacao != null ? !dataCriacao.equals(fatura.dataCriacao) : fatura.dataCriacao != null) return false;
        if (prazo != null ? !prazo.equals(fatura.prazo) : fatura.prazo != null) return false;
        if (valorEmbarcacoes != null ? !valorEmbarcacoes.equals(fatura.valorEmbarcacoes) : fatura.valorEmbarcacoes != null)
            return false;
        if (valorAgendamento != null ? !valorAgendamento.equals(fatura.valorAgendamento) : fatura.valorAgendamento != null)
            return false;
        if (valorManutencao != null ? !valorManutencao.equals(fatura.valorManutencao) : fatura.valorManutencao != null)
            return false;
        if (valorTotal != null ? !valorTotal.equals(fatura.valorTotal) : fatura.valorTotal != null) return false;
        if (idUtilizador != null ? !idUtilizador.equals(fatura.idUtilizador) : fatura.idUtilizador != null)
            return false;
        if (numFiscal != null ? !numFiscal.equals(fatura.numFiscal) : fatura.numFiscal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFatura;
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (prazo != null ? prazo.hashCode() : 0);
        result = 31 * result + (valorEmbarcacoes != null ? valorEmbarcacoes.hashCode() : 0);
        result = 31 * result + (valorAgendamento != null ? valorAgendamento.hashCode() : 0);
        result = 31 * result + (valorManutencao != null ? valorManutencao.hashCode() : 0);
        result = 31 * result + (valorTotal != null ? valorTotal.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        result = 31 * result + (numFiscal != null ? numFiscal.hashCode() : 0);
        return result;
    }
}
