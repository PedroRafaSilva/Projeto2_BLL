package Embarcacao;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"Embarcacao\"")
public class Embarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmbarcacao")
    private int idEmbarcacao;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic
    @Column(name = "idMarina")
    private Integer idMarina;
    @Basic
    @Column(name = "comprimento")
    private Integer comprimento;

    public int getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(int idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdMarina() {
        return idMarina;
    }

    public void setIdMarina(Integer idMarina) {
        this.idMarina = idMarina;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Embarcacao that = (Embarcacao) o;

        if (idEmbarcacao != that.idEmbarcacao) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (idUtilizador != null ? !idUtilizador.equals(that.idUtilizador) : that.idUtilizador != null) return false;
        if (idMarina != null ? !idMarina.equals(that.idMarina) : that.idMarina != null) return false;
        if (comprimento != null ? !comprimento.equals(that.comprimento) : that.comprimento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmbarcacao;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        result = 31 * result + (idMarina != null ? idMarina.hashCode() : 0);
        result = 31 * result + (comprimento != null ? comprimento.hashCode() : 0);
        return result;
    }
}
