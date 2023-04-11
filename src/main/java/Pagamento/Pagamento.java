package Pagamento;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Pagamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPagamento")
    private int idPagamento;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valorPago")
    private Float valorPago;
    @Basic
    @Column(name = "tipoPagamento")
    private String tipoPagamento;
    @Basic
    @Column(name = "idUtilizador")
    private Integer idUtilizador;
    @Basic
    @Column(name = "idFatura")
    private Integer idFatura;

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
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

        Pagamento pagamento = (Pagamento) o;

        if (idPagamento != pagamento.idPagamento) return false;
        if (data != null ? !data.equals(pagamento.data) : pagamento.data != null) return false;
        if (valorPago != null ? !valorPago.equals(pagamento.valorPago) : pagamento.valorPago != null) return false;
        if (tipoPagamento != null ? !tipoPagamento.equals(pagamento.tipoPagamento) : pagamento.tipoPagamento != null)
            return false;
        if (idUtilizador != null ? !idUtilizador.equals(pagamento.idUtilizador) : pagamento.idUtilizador != null)
            return false;
        if (idFatura != null ? !idFatura.equals(pagamento.idFatura) : pagamento.idFatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPagamento;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorPago != null ? valorPago.hashCode() : 0);
        result = 31 * result + (tipoPagamento != null ? tipoPagamento.hashCode() : 0);
        result = 31 * result + (idUtilizador != null ? idUtilizador.hashCode() : 0);
        result = 31 * result + (idFatura != null ? idFatura.hashCode() : 0);
        return result;
    }
}
