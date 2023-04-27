package Extra;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"Extra\"")
public class Extra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idExtra")
    private int idExtra;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valorAtualExtra")
    private Float valorAtualExtra;

    public int getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(int idExtra) {
        this.idExtra = idExtra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorAtualExtra() {
        return valorAtualExtra;
    }

    public void setValorAtualExtra(Float valorAtualExtra) {
        this.valorAtualExtra = valorAtualExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extra extra = (Extra) o;

        if (idExtra != extra.idExtra) return false;
        if (descricao != null ? !descricao.equals(extra.descricao) : extra.descricao != null) return false;
        if (valorAtualExtra != null ? !valorAtualExtra.equals(extra.valorAtualExtra) : extra.valorAtualExtra != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExtra;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valorAtualExtra != null ? valorAtualExtra.hashCode() : 0);
        return result;
    }
}
