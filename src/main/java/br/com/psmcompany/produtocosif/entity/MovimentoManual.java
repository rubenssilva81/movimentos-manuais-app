package br.com.psmcompany.produtocosif.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
public class MovimentoManual implements Serializable {

    @EmbeddedId
    private MovimentoManualPk pk;

    @Column(name = "DES_DESCRICAO", nullable = false)
    private String desDescricao;

    @Column(name = "DAT_MOVIMENTO", nullable = false)
    private Date datMovimento;

    @Column(name = "COD_USUARIO", nullable = false)
    private String codUsuario;

    @Column(name = "VAL_VALOR", nullable = false)
    private Double valValor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="COD_PRODUTO", referencedColumnName="COD_PRODUTO", insertable = false, updatable = false),
            @JoinColumn(name="COD_COSIF", referencedColumnName="COD_COSIF", insertable = false, updatable = false)
    })
    private ProdutoCosif produtoCosif;

    public MovimentoManualPk getPk() {
        return pk;
    }

    public void setPk(MovimentoManualPk pk) {
        this.pk = pk;
    }

    public String getDesDescricao() {
        return desDescricao;
    }

    public void setDesDescricao(String desDescricao) {
        this.desDescricao = desDescricao;
    }

    public Date getDatMovimento() {
        return datMovimento;
    }

    public void setDatMovimento(Date datMovimento) {
        this.datMovimento = datMovimento;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Double getValValor() {
        return valValor;
    }

    public void setValValor(Double valValor) {
        this.valValor = valValor;
    }

    public ProdutoCosif getProdutoCosif() {
        return produtoCosif;
    }

}
