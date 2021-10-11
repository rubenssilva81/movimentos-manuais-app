package br.com.psmcompany.produtocosif.service;

import br.com.psmcompany.produtocosif.entity.MovimentoManual;
import br.com.psmcompany.produtocosif.model.MovimentoManualVO;
import br.com.psmcompany.produtocosif.util.DataUtil;

public class MovimentoManualVOAdapter {

    public static MovimentoManualVO adapt(MovimentoManual mm)
    {
        return MovimentoManualVO.builder()
                .datMes(mm.getPk().getDatMes())
                .datAno(mm.getPk().getDatAno())
                .numLancamento(mm.getPk().getNumLancamento())
                .codProduto(mm.getPk().getCodProduto())
                .desProduto(mm.getProdutoCosif().getProduto().getDesProduto())
                .codCosif(mm.getPk().getCodCosif())
                .desDescricao(mm.getDesDescricao())
                .datMovimento(DataUtil.format(mm.getDatMovimento()))
                .codUsuario(mm.getCodUsuario())
                .valValor(mm.getValValor())
                .build();
    }
}
