package EstadoPagamento;

import ListaEstadoFatura.ListaEstadoFatura;
import Pagamento.Pagamento;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"EstadoPagamento\"")
public class EstadoPagamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "estadoPagamento", cascade = CascadeType.REMOVE)
    private List<ListaEstadoFatura> listaEstadoFaturas = new ArrayList<>();

    public List<ListaEstadoFatura> getListaEstadoFaturas() {
        return listaEstadoFaturas;
    }

    public void setListaEstadoFaturas(List<ListaEstadoFatura> listaEstadoFaturas) {
        this.listaEstadoFaturas = listaEstadoFaturas;
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

        EstadoPagamento that = (EstadoPagamento) o;

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
