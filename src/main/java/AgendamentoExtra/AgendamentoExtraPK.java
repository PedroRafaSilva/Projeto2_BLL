package AgendamentoExtra;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class AgendamentoExtraPK implements Serializable {
    @Column(name = "idAgendamento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    @Column(name = "idExtra")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExtra;

    public AgendamentoExtraPK(int idAgendamento, int idExtra) {
        this.idAgendamento = idAgendamento;
        this.idExtra = idExtra;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendamentoExtraPK that = (AgendamentoExtraPK) o;

        if (idAgendamento != that.idAgendamento) return false;
        if (idExtra != that.idExtra) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgendamento;
        result = 31 * result + idExtra;
        return result;
    }
}
