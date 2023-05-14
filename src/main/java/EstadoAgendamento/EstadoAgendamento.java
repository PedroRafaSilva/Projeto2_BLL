package EstadoAgendamento;

import ListaEstadoAgendamento.ListaEstadoAgendamento;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"EstadoAgendamento\"")
public class EstadoAgendamento {
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "estadoAgendamento", cascade = CascadeType.REMOVE)
    private List<ListaEstadoAgendamento> listaEstadoAgendamentoes = new ArrayList<>();

    public List<ListaEstadoAgendamento> getListaEstadoAgendamentoes() {
        return listaEstadoAgendamentoes;
    }

    public void setListaEstadoAgendamentoes(List<ListaEstadoAgendamento> listaEstadoAgendamentoes) {
        this.listaEstadoAgendamentoes = listaEstadoAgendamentoes;
    }

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
