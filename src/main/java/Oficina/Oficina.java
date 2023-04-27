package Oficina;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"Oficina\"")
public class Oficina {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOficina")
    private int idOficina;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cpostal")
    private String cpostal;

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
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

        if (idOficina != oficina.idOficina) return false;
        if (nome != null ? !nome.equals(oficina.nome) : oficina.nome != null) return false;
        if (cpostal != null ? !cpostal.equals(oficina.cpostal) : oficina.cpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOficina;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        return result;
    }
}
