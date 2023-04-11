package Comprimento;

import jakarta.persistence.*;

@Entity
public class Comprimento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comprimento")
    private int comprimento;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valorComprimento")
    private Float valorComprimento;

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorComprimento() {
        return valorComprimento;
    }

    public void setValorComprimento(Float valorComprimento) {
        this.valorComprimento = valorComprimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comprimento that = (Comprimento) o;

        if (comprimento != that.comprimento) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (valorComprimento != null ? !valorComprimento.equals(that.valorComprimento) : that.valorComprimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comprimento;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valorComprimento != null ? valorComprimento.hashCode() : 0);
        return result;
    }
}
