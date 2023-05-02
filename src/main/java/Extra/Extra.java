package Extra;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"Extra\"")
public class Extra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idextra")
    private int idextra;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valoratualextra")
    private Float valoratualextra;

    public int getIdextra() {
        return idextra;
    }

    public void setIdextra(int idextra) {
        this.idextra = idextra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValoratualextra() {
        return valoratualextra;
    }

    public void setValoratualextra(Float valoratualextra) {
        this.valoratualextra = valoratualextra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extra extra = (Extra) o;

        if (idextra != extra.idextra) return false;
        if (descricao != null ? !descricao.equals(extra.descricao) : extra.descricao != null) return false;
        if (valoratualextra != null ? !valoratualextra.equals(extra.valoratualextra) : extra.valoratualextra != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idextra;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valoratualextra != null ? valoratualextra.hashCode() : 0);
        return result;
    }
}
