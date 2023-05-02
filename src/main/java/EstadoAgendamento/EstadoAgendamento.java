package EstadoAgendamento;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"EstadoAgendamento\"")
public class EstadoAgendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "estado")
    private String estado;

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoAgendamento that = (EstadoAgendamento) o;

        if (idestado != that.idestado) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idestado;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
