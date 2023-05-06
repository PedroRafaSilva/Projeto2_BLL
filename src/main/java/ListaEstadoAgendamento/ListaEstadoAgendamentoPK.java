package ListaEstadoAgendamento;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEstadoAgendamentoPK implements Serializable {
    @Column(name = "idagendamento")
    @Id
    private int idagendamento;
    @Column(name = "idestado")
    @Id
    private int idestado;

    public ListaEstadoAgendamentoPK() {
    }

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEstadoAgendamentoPK that = (ListaEstadoAgendamentoPK) o;

        if (idagendamento != that.idagendamento) return false;
        if (idestado != that.idestado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idestado;
        return result;
    }
}
