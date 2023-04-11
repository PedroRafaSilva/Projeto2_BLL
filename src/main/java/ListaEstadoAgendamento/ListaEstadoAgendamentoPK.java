package ListaEstadoAgendamento;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEstadoAgendamentoPK implements Serializable {
    @Column(name = "idAgendamento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    @Column(name = "idEstado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEstadoAgendamentoPK that = (ListaEstadoAgendamentoPK) o;

        if (idAgendamento != that.idAgendamento) return false;
        if (idEstado != that.idEstado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgendamento;
        result = 31 * result + idEstado;
        return result;
    }
}
