package ListaEstadoFatura;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEstadoFaturaPK implements Serializable {
    @Column(name = "idfatura")
    @Id
    private int idfatura;
    @Column(name = "idestado")
    @Id
    private int idestado;

    public ListaEstadoFaturaPK() {
    }

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
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

        ListaEstadoFaturaPK that = (ListaEstadoFaturaPK) o;

        if (idfatura != that.idfatura) return false;
        if (idestado != that.idestado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idestado;
        return result;
    }
}
