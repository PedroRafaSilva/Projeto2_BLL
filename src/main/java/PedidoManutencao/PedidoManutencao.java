package PedidoManutencao;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "\"Projecto1\".\"PedidoManutencao\"")
public class PedidoManutencao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPedido")
    private int idPedido;
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
    @Column(name = "idEmbarcacao")
    private Integer idEmbarcacao;
    @Basic
    @Column(name = "idOficina")
    private Integer idOficina;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic
    @Column(name = "idFatura")
    private Integer idFatura;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public Integer getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(Integer idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoManutencao that = (PedidoManutencao) o;

        if (idPedido != that.idPedido) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (idEmbarcacao != null ? !idEmbarcacao.equals(that.idEmbarcacao) : that.idEmbarcacao != null) return false;
        if (idOficina != null ? !idOficina.equals(that.idOficina) : that.idOficina != null) return false;
        if (idUtilizador != null ? !idUtilizador.equals(that.idUtilizador) : that.idUtilizador != null) return false;
        if (idFatura != null ? !idFatura.equals(that.idFatura) : that.idFatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (idEmbarcacao != null ? idEmbarcacao.hashCode() : 0);
        result = 31 * result + (idOficina != null ? idOficina.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        result = 31 * result + (idFatura != null ? idFatura.hashCode() : 0);
        return result;
    }
}
