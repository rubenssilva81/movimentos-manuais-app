package br.com.psmcompany.produtocosif.model;

import lombok.Builder;

@Builder
public class ProdutoVO {

    private String codProduto;
    private String desProduto;

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getDesProduto() {
        return desProduto;
    }

    public void setDesProduto(String desProduto) {
        this.desProduto = desProduto;
    }
}
