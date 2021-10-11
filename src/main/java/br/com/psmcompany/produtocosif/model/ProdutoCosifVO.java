package br.com.psmcompany.produtocosif.model;

import lombok.Builder;

@Builder
public class ProdutoCosifVO {

    private String codProduto;
    private String codCosif;
    private String codClassificacao;

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

    public String getCodClassificacao() {
        return codClassificacao;
    }

    public void setCodClassificacao(String codClassificacao) {
        this.codClassificacao = codClassificacao;
    }
}
