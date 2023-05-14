package Pagamento;

import EstadoPagamento.EstadoPagamento;
import Fatura.Fatura;
import Utilizador.Utilizador;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "\"Projecto1\".\"Pagamento\"")
public class Pagamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpagamento")
    private int idpagamento;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valorpago")
    private Float valorpago;
    @Basic
    @Column(name = "tipopagamento")
    private String tipopagamento;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;
    @Basic
    @Column(name = "idfatura")
    private Integer idfatura;

    @ManyToOne
    @JoinColumn(name = "idutilizador", updatable = false, insertable = false)
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(name = "idfatura", updatable = false, insertable = false)
    private Fatura fatura;

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorpago() {
        return valorpago;
    }

    public void setValorpago(Float valorpago) {
        this.valorpago = valorpago;
    }

    public String getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
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

        Pagamento pagamento = (Pagamento) o;

        if (idpagamento != pagamento.idpagamento) return false;
        if (data != null ? !data.equals(pagamento.data) : pagamento.data != null) return false;
        if (valorpago != null ? !valorpago.equals(pagamento.valorpago) : pagamento.valorpago != null) return false;
        if (tipopagamento != null ? !tipopagamento.equals(pagamento.tipopagamento) : pagamento.tipopagamento != null)
            return false;
        if (idutilizador != null ? !idutilizador.equals(pagamento.idutilizador) : pagamento.idutilizador != null)
            return false;
        if (idfatura != null ? !idfatura.equals(pagamento.idfatura) : pagamento.idfatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpagamento;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorpago != null ? valorpago.hashCode() : 0);
        result = 31 * result + (tipopagamento != null ? tipopagamento.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (idfatura != null ? idfatura.hashCode() : 0);
        return result;
    }
}
