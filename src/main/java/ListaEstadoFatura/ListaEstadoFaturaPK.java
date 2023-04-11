package ListaEstadoFatura;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEstadoFaturaPK implements Serializable {
    @Column(name = "idFatura")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFatura;
    @Column(name = "idEstado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
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

        ListaEstadoFaturaPK that = (ListaEstadoFaturaPK) o;

        if (idFatura != that.idFatura) return false;
        if (idEstado != that.idEstado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFatura;
        result = 31 * result + idEstado;
        return result;
    }
}
