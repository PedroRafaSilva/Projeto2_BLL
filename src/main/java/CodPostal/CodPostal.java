package CodPostal;

import Marina.Marina;
import Oficina.Oficina;
import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"CodPostal\"")
public class CodPostal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cpostal")
    private String cpostal;
    @Basic
    @Column(name = "localidade")
    private String localidade;
    @OneToMany(mappedBy = "codPostalByCpostal")
    private Collection<Marina> marinasByCpostal;
    @OneToMany(mappedBy = "codPostalByCpostal")
    private Collection<Oficina> oficinasByCpostal;
    @OneToMany(mappedBy = "codPostalByCpostal")
    private Collection<Utilizador> utilizadorsByCpostal;

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

    public Collection<Marina> getMarinasByCpostal() {
        return marinasByCpostal;
    }

    public void setMarinasByCpostal(Collection<Marina> marinasByCpostal) {
        this.marinasByCpostal = marinasByCpostal;
    }

    public Collection<Oficina> getOficinasByCpostal() {
        return oficinasByCpostal;
    }

    public void setOficinasByCpostal(Collection<Oficina> oficinasByCpostal) {
        this.oficinasByCpostal = oficinasByCpostal;
    }

    public Collection<Utilizador> getUtilizadorsByCpostal() {
        return utilizadorsByCpostal;
    }

    public void setUtilizadorsByCpostal(Collection<Utilizador> utilizadorsByCpostal) {
        this.utilizadorsByCpostal = utilizadorsByCpostal;
    }
}
