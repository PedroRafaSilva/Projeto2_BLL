package TipoUtilizador;

import jakarta.persistence.*;

@Entity
public class TipoUtilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTipoUtilizador")
    private int idTipoUtilizador;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    public int getIdTipoUtilizador() {
        return idTipoUtilizador;
    }

    public void setIdTipoUtilizador(int idTipoUtilizador) {
        this.idTipoUtilizador = idTipoUtilizador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUtilizador that = (TipoUtilizador) o;

        if (idTipoUtilizador != that.idTipoUtilizador) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoUtilizador;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
