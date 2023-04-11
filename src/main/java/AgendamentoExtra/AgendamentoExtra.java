package AgendamentoExtra;

import jakarta.persistence.*;

@Entity
@IdClass(AgendamentoExtraPK.class)
public class AgendamentoExtra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAgendamento")
    private int idAgendamento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idExtra")
    private int idExtra;
    @Basic
    @Column(name = "valorExtra")
    private Float valorExtra;
    @Basic
    @Column(name = "qtd")
    private Integer qtd;

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(int idExtra) {
        this.idExtra = idExtra;
    }

    public Float getValorExtra() {
        return valorExtra;
    }

    public void setValorExtra(Float valorExtra) {
        this.valorExtra = valorExtra;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendamentoExtra that = (AgendamentoExtra) o;

        if (idAgendamento != that.idAgendamento) return false;
        if (idExtra != that.idExtra) return false;
        if (valorExtra != null ? !valorExtra.equals(that.valorExtra) : that.valorExtra != null) return false;
        if (qtd != null ? !qtd.equals(that.qtd) : that.qtd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgendamento;
        result = 31 * result + idExtra;
        result = 31 * result + (valorExtra != null ? valorExtra.hashCode() : 0);
        result = 31 * result + (qtd != null ? qtd.hashCode() : 0);
        return result;
    }
}
