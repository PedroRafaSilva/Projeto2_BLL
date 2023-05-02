package PedidoManutencao;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "\"Projecto1\".\"PedidoManutencao\"")
public class PedidoManutencao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpedido")
    private int idpedido;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valor")
    private Float valor;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "idembarcacao")
    private Integer idembarcacao;
    @Basic
    @Column(name = "idoficina")
    private Integer idoficina;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;
    @Basic
    @Column(name = "idfatura")
    private Integer idfatura;

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(Integer idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public Integer getIdoficina() {
        return idoficina;
    }

    public void setIdoficina(Integer idoficina) {
        this.idoficina = idoficina;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    public Integer getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(Integer idfatura) {
        this.idfatura = idfatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoManutencao that = (PedidoManutencao) o;

        if (idpedido != that.idpedido) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (idembarcacao != null ? !idembarcacao.equals(that.idembarcacao) : that.idembarcacao != null) return false;
        if (idoficina != null ? !idoficina.equals(that.idoficina) : that.idoficina != null) return false;
        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;
        if (idfatura != null ? !idfatura.equals(that.idfatura) : that.idfatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpedido;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (idembarcacao != null ? idembarcacao.hashCode() : 0);
        result = 31 * result + (idoficina != null ? idoficina.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (idfatura != null ? idfatura.hashCode() : 0);
        return result;
    }
}
