package Agendamento;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Agendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAgendamento")
    private int idAgendamento;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valorExtras")
    private Float valorExtras;
    @Basic
    @Column(name = "idEmbarcacao")
    private Integer idEmbarcacao;
    @Basic
    @Column(name = "idFatura")
    private Integer idFatura;
    @Basic
    @Column(name = "hora")
    private Time hora;
    @Basic
    @Column(name = "duracao")
    private Object duracao;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorExtras() {
        return valorExtras;
    }

    public void setValorExtras(Float valorExtras) {
        this.valorExtras = valorExtras;
    }

    public Integer getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(Integer idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
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

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agendamento that = (Agendamento) o;

        if (idAgendamento != that.idAgendamento) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valorExtras != null ? !valorExtras.equals(that.valorExtras) : that.valorExtras != null) return false;
        if (idEmbarcacao != null ? !idEmbarcacao.equals(that.idEmbarcacao) : that.idEmbarcacao != null) return false;
        if (idFatura != null ? !idFatura.equals(that.idFatura) : that.idFatura != null) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;
        if (duracao != null ? !duracao.equals(that.duracao) : that.duracao != null) return false;
        if (idUtilizador != null ? !idUtilizador.equals(that.idUtilizador) : that.idUtilizador != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgendamento;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorExtras != null ? valorExtras.hashCode() : 0);
        result = 31 * result + (idEmbarcacao != null ? idEmbarcacao.hashCode() : 0);
        result = 31 * result + (idFatura != null ? idFatura.hashCode() : 0);
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return result;
    }
}
