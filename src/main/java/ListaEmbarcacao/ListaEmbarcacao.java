package ListaEmbarcacao;

import jakarta.persistence.*;

@Entity
@IdClass(ListaEmbarcacaoPK.class)
@Table(name = "\"Projecto1\".\"ListaEmbarcacao\"")
public class ListaEmbarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfatura")
    private int idfatura;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idembarcacao")
    private int idembarcacao;
    @Basic
    @Column(name = "valorpagar")
    private Float valorpagar;

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
    }

    public int getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(int idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public Float getValorpagar() {
        return valorpagar;
    }

    public void setValorpagar(Float valorpagar) {
        this.valorpagar = valorpagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEmbarcacao that = (ListaEmbarcacao) o;

        if (idfatura != that.idfatura) return false;
        if (idembarcacao != that.idembarcacao) return false;
        if (valorpagar != null ? !valorpagar.equals(that.valorpagar) : that.valorpagar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idembarcacao;
        result = 31 * result + (valorpagar != null ? valorpagar.hashCode() : 0);
        return result;
    }
}
