package AgendamentoExtra;

import Agendamento.Agendamento;
import Extra.Extra;
import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"AgendamentoExtra\"")
@IdClass(AgendamentoExtraPK.class)
public class AgendamentoExtra {

    @Id
    @Column(name = "idagendamento")
    private int idagendamento;
    @Id
    @Column(name = "idextra")
    private int idextra;
    @Basic
    @Column(name = "valorextra")
    private Float valorextra;
    @Basic
    @Column(name = "qtd")
    private Integer qtd;
    @ManyToOne
    @JoinColumn(name = "idagendamento", updatable = false, insertable = false)
    private Agendamento agendamento;
    @ManyToOne
    @JoinColumn(name = "idextra", updatable = false, insertable = false)
    private Extra extra;



    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public int getIdextra() {
        return idextra;
    }

    public void setIdextra(int idextra) {
        this.idextra = idextra;
    }

    public Float getValorextra() {
        return valorextra;
    }

    public void setValorextra(Float valorextra) {
        this.valorextra = valorextra;
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

        if (idagendamento != that.idagendamento) return false;
        if (idextra != that.idextra) return false;
        if (valorextra != null ? !valorextra.equals(that.valorextra) : that.valorextra != null) return false;
        if (qtd != null ? !qtd.equals(that.qtd) : that.qtd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idextra;
        result = 31 * result + (valorextra != null ? valorextra.hashCode() : 0);
        result = 31 * result + (qtd != null ? qtd.hashCode() : 0);
        return result;
    }
}
