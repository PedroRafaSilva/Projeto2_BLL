package Marina;

import jakarta.persistence.*;

@Entity
public class Marina {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMarina")
    private int idMarina;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cpostal")
    private String cpostal;

    public int getIdMarina() {
        return idMarina;
    }

    public void setIdMarina(int idMarina) {
        this.idMarina = idMarina;
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

        Marina marina = (Marina) o;

        if (idMarina != marina.idMarina) return false;
        if (nome != null ? !nome.equals(marina.nome) : marina.nome != null) return false;
        if (cpostal != null ? !cpostal.equals(marina.cpostal) : marina.cpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMarina;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        return result;
    }
}
