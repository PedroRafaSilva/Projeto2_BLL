package CodPostal;

import Marina.Marina;
import Oficina.Oficina;
import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "\"Projecto1\".\"CodPostal\"")
public class CodPostal {

    @Id
    @Column(name = "cpostal")
    private String cpostal;
    @Basic
    @Column(name = "localidade")
    private String localidade;
    @OneToMany(mappedBy = "codPostal", cascade = CascadeType.REMOVE)
    private List<Marina> marinas = new ArrayList<>();
    @OneToMany(mappedBy = "codPostal", cascade = CascadeType.REMOVE)
    private List<Oficina> oficinas = new ArrayList<>();



    public List<Oficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public List<Marina> getMarinas() {
        return marinas;
    }

    public void setMarinas(List<Marina> marinas) {
        this.marinas = marinas;
    }

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
