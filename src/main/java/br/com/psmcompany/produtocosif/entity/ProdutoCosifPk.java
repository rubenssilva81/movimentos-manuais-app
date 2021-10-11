package br.com.psmcompany.produtocosif.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoCosifPk implements Serializable {

    @Column(name = "COD_PRODUTO", nullable = false)
    private String codProduto;

    @Column(name = "COD_COSIF", nullable = false)
    private String codCosif;

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
        ProdutoCosifPk that = (ProdutoCosifPk) o;
        return Objects.equals(codProduto, that.codProduto) && Objects.equals(codCosif, that.codCosif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProduto, codCosif);
    }
}
