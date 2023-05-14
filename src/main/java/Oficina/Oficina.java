package Oficina;

import CodPostal.CodPostal;
import PedidoManutencao.PedidoManutencao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"Oficina\"")
public class Oficina {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idoficina")
    private int idoficina;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cpostal")
    private String cpostal;

    @ManyToOne
    @JoinColumn(name = "cpostal", updatable = false, insertable = false)
    private CodPostal codPostal;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.REMOVE)
    private List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

    public List<PedidoManutencao> getPedidoManutencaos() {
        return pedidoManutencaos;
    }

    public void setPedidoManutencaos(List<PedidoManutencao> pedidoManutencaos) {
        this.pedidoManutencaos = pedidoManutencaos;
    }

    public CodPostal getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(CodPostal codPostal) {
        this.codPostal = codPostal;
    }

    public int getIdoficina() {
        return idoficina;
    }

    public void setIdoficina(int idoficina) {
        this.idoficina = idoficina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oficina oficina = (Oficina) o;

        if (idoficina != oficina.idoficina) return false;
        if (nome != null ? !nome.equals(oficina.nome) : oficina.nome != null) return false;
        if (cpostal != null ? !cpostal.equals(oficina.cpostal) : oficina.cpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idoficina;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        return result;
    }
}
