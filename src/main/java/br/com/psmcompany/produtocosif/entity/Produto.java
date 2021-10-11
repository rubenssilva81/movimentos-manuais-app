package br.com.psmcompany.produtocosif.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @Column(name = "COD_PRODUTO", nullable = false)
    private String codProduto;

    @Column(name = "DES_PRODUTO")
    private String desProduto;

    @Column(name = "STA_STATUS")
    private String staStatus;

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

    public String getStaStatus() {
        return staStatus;
    }

    public void setStaStatus(String staStatus) {
        this.staStatus = staStatus;
    }

}
