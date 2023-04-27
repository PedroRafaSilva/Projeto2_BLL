package ListaEmbarcacao;

import jakarta.persistence.*;

@Entity
@IdClass(ListaEmbarcacaoPK.class)
@Table(name = "\"Projecto1\".\"ListaEmbarcacao\"")
public class ListaEmbarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFatura")
    private int idFatura;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmbarcacao")
    private int idEmbarcacao;
    @Basic
    @Column(name = "valorPagar")
    private Float valorPagar;

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(int idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public Float getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Float valorPagar) {
        this.valorPagar = valorPagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEmbarcacao that = (ListaEmbarcacao) o;

        if (idFatura != that.idFatura) return false;
        if (idEmbarcacao != that.idEmbarcacao) return false;
        if (valorPagar != null ? !valorPagar.equals(that.valorPagar) : that.valorPagar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFatura;
        result = 31 * result + idEmbarcacao;
        result = 31 * result + (valorPagar != null ? valorPagar.hashCode() : 0);
        return result;
    }
}
