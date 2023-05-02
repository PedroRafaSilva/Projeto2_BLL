package ListaEmbarcacao;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEmbarcacaoPK implements Serializable {
    @Column(name = "idfatura")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfatura;
    @Column(name = "idembarcacao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idembarcacao;

    public ListaEmbarcacaoPK(int idfatura, int idembarcacao) {
        this.idfatura = idfatura;
        this.idembarcacao = idembarcacao;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEmbarcacaoPK that = (ListaEmbarcacaoPK) o;

        if (idfatura != that.idfatura) return false;
        if (idembarcacao != that.idembarcacao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idembarcacao;
        return result;
    }
}
