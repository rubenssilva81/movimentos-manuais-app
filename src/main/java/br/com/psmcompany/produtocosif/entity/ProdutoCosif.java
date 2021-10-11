package br.com.psmcompany.produtocosif.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO_COSIF")
public class ProdutoCosif {

    @EmbeddedId
    private ProdutoCosifPk pk;

    @Column(name = "COD_CLASSIFICACAO", nullable = false)
    private String codClassificacao;

    @Column(name = "STA_STATUS", nullable = false)
    private String staStatus;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false)
    private Produto produto;

    public ProdutoCosifPk getPk() {
        return pk;
    }

    public void setPk(ProdutoCosifPk pk) {
        this.pk = pk;
    }

    public String getCodClassificacao() {
        return codClassificacao;
    }

    public void setCodClassificacao(String codClassificacao) {
        this.codClassificacao = codClassificacao;
    }

    public String getStaStatus() {
        return staStatus;
    }

    public void setStaStatus(String staStatus) {
        this.staStatus = staStatus;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
