package Agendamento;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "\"Projecto1\".\"Agendamento\"")
public class Agendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idagendamento")
    private int idagendamento;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valorextras")
    private Float valorextras;
    @Basic
    @Column(name = "idembarcacao")
    private Integer idembarcacao;
    @Basic
    @Column(name = "idfatura")
    private Integer idfatura;
    @Basic
    @Column(name = "hora")
    private Time hora;
    @Basic
    @Column(name = "duracao")
    private Object duracao;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorextras() {
        return valorextras;
    }

    public void setValorextras(Float valorextras) {
        this.valorextras = valorextras;
    }

    public Integer getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(Integer idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public Integer getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(Integer idfatura) {
        this.idfatura = idfatura;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Object getDuracao() {
        return duracao;
    }

    public void setDuracao(Object duracao) {
        this.duracao = duracao;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agendamento that = (Agendamento) o;

        if (idagendamento != that.idagendamento) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valorextras != null ? !valorextras.equals(that.valorextras) : that.valorextras != null) return false;
        if (idembarcacao != null ? !idembarcacao.equals(that.idembarcacao) : that.idembarcacao != null) return false;
        if (idfatura != null ? !idfatura.equals(that.idfatura) : that.idfatura != null) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;
        if (duracao != null ? !duracao.equals(that.duracao) : that.duracao != null) return false;
        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorextras != null ? valorextras.hashCode() : 0);
        result = 31 * result + (idembarcacao != null ? idembarcacao.hashCode() : 0);
        result = 31 * result + (idfatura != null ? idfatura.hashCode() : 0);
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        return result;
    }
}
