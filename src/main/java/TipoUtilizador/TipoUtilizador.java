package TipoUtilizador;

import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"TipoUtilizador\"")
public class TipoUtilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtipoutilizador")
    private int idtipoutilizador;
    @Basic
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tipoUtilizador", cascade = CascadeType.REMOVE)
    private List<Utilizador> utilizadores = new ArrayList<>();

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public int getIdtipoutilizador() {
        return idtipoutilizador;
    }

    public void setIdtipoutilizador(int idtipoutilizador) {
        this.idtipoutilizador = idtipoutilizador;
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

        if (idtipoutilizador != that.idtipoutilizador) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtipoutilizador;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
