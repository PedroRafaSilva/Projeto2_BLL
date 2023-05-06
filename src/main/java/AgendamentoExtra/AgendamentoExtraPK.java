package AgendamentoExtra;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class AgendamentoExtraPK implements Serializable {
    @Column(name = "idagendamento")
    @Id
    private int idagendamento;
    @Column(name = "idextra")
    @Id
    private int idextra;

    public AgendamentoExtraPK() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendamentoExtraPK that = (AgendamentoExtraPK) o;

        if (idagendamento != that.idagendamento) return false;
        if (idextra != that.idextra) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idextra;
        return result;
    }
}
