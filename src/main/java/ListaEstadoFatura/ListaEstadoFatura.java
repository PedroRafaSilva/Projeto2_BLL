package ListaEstadoFatura;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@IdClass(ListaEstadoFaturaPK.class)
public class ListaEstadoFatura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFatura")
    private int idFatura;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEstado")
    private int idEstado;
    @Basic
    @Column(name = "data")
    private Date data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEstadoFatura that = (ListaEstadoFatura) o;

        if (idFatura != that.idFatura) return false;
        if (idEstado != that.idEstado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFatura;
        result = 31 * result + idEstado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
