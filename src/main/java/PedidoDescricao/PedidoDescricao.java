package PedidoDescricao;

import PedidoManutencao.PedidoManutencao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"PedidoDescricao\"")
public class PedidoDescricao {
    @Id
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valor")
    private double valor;

    @OneToMany(mappedBy = "pedidoDescricao", cascade = CascadeType.REMOVE)
    private List<PedidoManutencao> pedidoManutencaos = new ArrayList<>();

    public List<PedidoManutencao> getPedidoManutencaos() {
        return pedidoManutencaos;
    }

    public void setPedidoManutencaos(List<PedidoManutencao> pedidoManutencaos) {
        this.pedidoManutencaos = pedidoManutencaos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoDescricao that = (PedidoDescricao) o;

        if (Double.compare(that.valor, valor) != 0) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = descricao != null ? descricao.hashCode() : 0;
        temp = Double.doubleToLongBits(valor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
