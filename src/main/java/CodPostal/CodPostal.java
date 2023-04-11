package CodPostal;

import jakarta.persistence.*;

@Entity
public class CodPostal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cpostal")
    private String cpostal;
    @Basic
    @Column(name = "localidade")
    private String localidade;

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodPostal codPostal = (CodPostal) o;

        if (cpostal != null ? !cpostal.equals(codPostal.cpostal) : codPostal.cpostal != null) return false;
        if (localidade != null ? !localidade.equals(codPostal.localidade) : codPostal.localidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cpostal != null ? cpostal.hashCode() : 0;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        return result;
    }
}
