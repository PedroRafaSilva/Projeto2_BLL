package ListaEmbarcacao;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ListaEmbarcacaoPK implements Serializable {
    @Column(name = "idFatura")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFatura;
    @Column(name = "idEmbarcacao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmbarcacao;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEmbarcacaoPK that = (ListaEmbarcacaoPK) o;

        if (idFatura != that.idFatura) return false;
        if (idEmbarcacao != that.idEmbarcacao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFatura;
        result = 31 * result + idEmbarcacao;
        return result;
    }
}
