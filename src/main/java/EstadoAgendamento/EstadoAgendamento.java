package EstadoAgendamento;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"EstadoAgendamento\"")
public class EstadoAgendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEstado")
    private int idEstado;
    @Basic
    @Column(name = "Estado")
    private String estado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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

        if (idEstado != that.idEstado) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstado;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
