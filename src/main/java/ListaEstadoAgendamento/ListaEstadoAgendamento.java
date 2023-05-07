package ListaEstadoAgendamento;

import EstadoAgendamento.EstadoAgendamento;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@IdClass(ListaEstadoAgendamentoPK.class)
@Table(name = "\"Projecto1\".\"ListaEstadoAgendamento\"")
public class ListaEstadoAgendamento {

    @Id
    @Column(name = "idagendamento")
    private int idagendamento;

    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "data")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "idestado", updatable = false, insertable = false)
    private EstadoAgendamento estadoAgendamento;

    public EstadoAgendamento getEstadoAgendamento() {
        return estadoAgendamento;
    }
    public void setEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        this.estadoAgendamento = estadoAgendamento;
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEstadoAgendamento that = (ListaEstadoAgendamento) o;

        if (idagendamento != that.idagendamento) return false;
        if (idestado != that.idestado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idestado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
