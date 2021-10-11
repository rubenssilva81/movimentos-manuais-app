package br.com.psmcompany.produtocosif.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimentoManualVO {

    private int datMes;
    private int datAno;
    private int numLancamento;
    private String codProduto;
    private String desProduto;
    private String codCosif;
    private String desDescricao;
    private String datMovimento;
    private String codUsuario;
    private double valValor;

    public int getDatMes() {
        return datMes;
    }

    public void setDatMes(int datMes) {
        this.datMes = datMes;
    }

    public int getDatAno() {
        return datAno;
    }

    public void setDatAno(int datAno) {
        this.datAno = datAno;
    }

    public int getNumLancamento() {
        return numLancamento;
    }

    public void setNumLancamento(int numLancamento) {
        this.numLancamento = numLancamento;
    }

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

    public String getCodCosif() {
        return codCosif;
    }

    public void setCodCosif(String codCosif) {
        this.codCosif = codCosif;
    }

    public String getDesDescricao() {
        return desDescricao;
    }

    public void setDesDescricao(String desDescricao) {
        this.desDescricao = desDescricao;
    }

    public String getDatMovimento() {
        return datMovimento;
    }

    public void setDatMovimento(String datMovimento) {
        this.datMovimento = datMovimento;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public double getValValor() {
        return valValor;
    }

    public void setValValor(double valValor) {
        this.valValor = valValor;
    }

    @Override
    public String toString() {
        return "MovimentoManualVO{" +
                "datMes=" + datMes +
                ", datAno=" + datAno +
                ", numLancamento=" + numLancamento +
                ", codProduto='" + codProduto + '\'' +
                ", desProduto='" + desProduto + '\'' +
                ", codCosif='" + codCosif + '\'' +
                ", desDescricao='" + desDescricao + '\'' +
                ", datMovimento='" + datMovimento + '\'' +
                ", codUsuario='" + codUsuario + '\'' +
                ", valValor=" + valValor +
                '}';
    }
}
