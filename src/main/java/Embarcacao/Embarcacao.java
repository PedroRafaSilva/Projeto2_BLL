package Embarcacao;

import Comprimento.Comprimento;
import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"Embarcacao\"")
public class Embarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idembarcacao")
    private int idembarcacao;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;
    @Basic
    @Column(name = "idmarina")
    private Integer idmarina;
    @ManyToOne
    @JoinColumn(name = "comprimento", referencedColumnName = "comprimento")
    private Comprimento comprimentoByComprimento;

    public int getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(int idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    public Integer getIdmarina() {
        return idmarina;
    }

    public void setIdmarina(Integer idmarina) {
        this.idmarina = idmarina;
    }




    @Override
    public int hashCode() {
        int result = idembarcacao;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (idmarina != null ? idmarina.hashCode() : 0);
        return result;
    }

    public Comprimento getComprimentoByComprimento() {
        return comprimentoByComprimento;
    }

    public void setComprimentoByComprimento(Comprimento comprimentoByComprimento) {
        this.comprimentoByComprimento = comprimentoByComprimento;
    }
}
