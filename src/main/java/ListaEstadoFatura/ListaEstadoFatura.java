package ListaEstadoFatura;

import EstadoPagamento.EstadoPagamento;
import Fatura.Fatura;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@IdClass(ListaEstadoFaturaPK.class)
@Table(name = "\"Projecto1\".\"ListaEstadoFatura\"")
public class ListaEstadoFatura {

    @Id
    @Column(name = "idfatura")
    private int idfatura;

    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "idfatura", updatable = false, insertable = false)
    private Fatura fatura;

    @ManyToOne
    @JoinColumn(name = "idestado", updatable = false, insertable = false)
    private EstadoPagamento estadoPagamento;

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public EstadoPagamento getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
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

        if (idfatura != that.idfatura) return false;
        if (idestado != that.idestado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idestado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
