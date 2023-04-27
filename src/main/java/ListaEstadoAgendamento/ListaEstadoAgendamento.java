package ListaEstadoAgendamento;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@IdClass(ListaEstadoAgendamentoPK.class)
@Table(name = "\"Projecto1\".\"ListaEstadoAgendamento\"")
public class ListaEstadoAgendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAgendamento")
    private int idAgendamento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEstado")
    private int idEstado;
    @Basic
    @Column(name = "data")
    private Date data;

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

        ListaEstadoAgendamento that = (ListaEstadoAgendamento) o;

        if (idAgendamento != that.idAgendamento) return false;
        if (idEstado != that.idEstado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAgendamento;
        result = 31 * result + idEstado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
