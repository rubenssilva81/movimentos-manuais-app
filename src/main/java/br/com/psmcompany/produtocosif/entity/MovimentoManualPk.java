package br.com.psmcompany.produtocosif.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovimentoManualPk implements Serializable {

    @Column(name = "DAT_MES", nullable = false)
    private Integer datMes;

    @Column(name = "DAT_ANO", nullable = false)
    private Integer datAno;

    @Column(name = "NUM_LANCAMENTO", nullable = false)
    private Integer numLancamento;

    @Column(name = "COD_PRODUTO", nullable = false)
    private String codProduto;

    @Column(name = "COD_COSIF", nullable = false)
    private String codCosif;

    public Integer getDatMes() {
        return datMes;
    }

    public void setDatMes(Integer datMes) {
        this.datMes = datMes;
    }

    public Integer getDatAno() {
        return datAno;
    }

    public void setDatAno(Integer datAno) {
        this.datAno = datAno;
    }

    public Integer getNumLancamento() {
        return numLancamento;
    }

    public void setNumLancamento(Integer numLancamento) {
        this.numLancamento = numLancamento;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodCosif() {
        return codCosif;
    }

    public void setCodCosif(String codCosif) {
        this.codCosif = codCosif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimentoManualPk that = (MovimentoManualPk) o;
        return Objects.equals(datMes, that.datMes) && Objects.equals(datAno, that.datAno) && Objects.equals(numLancamento, that.numLancamento) && Objects.equals(codProduto, that.codProduto) && Objects.equals(codCosif, that.codCosif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datMes, datAno, numLancamento, codProduto, codCosif);
    }
}
