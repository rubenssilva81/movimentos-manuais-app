package br.com.psmcompany.produtocosif.service;

import br.com.psmcompany.produtocosif.entity.ProdutoCosif;
import br.com.psmcompany.produtocosif.entity.ProdutoCosifPk;
import br.com.psmcompany.produtocosif.model.ProdutoCosifVO;
import br.com.psmcompany.produtocosif.repository.ProdutoCosifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoCosifService {

    @Autowired
    private ProdutoCosifRepository produtoCosifRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ProdutoCosifVO> findProdutosCosif(String codProduto) {

        ProdutoCosifPk pk = new ProdutoCosifPk();
        pk.setCodProduto(codProduto);
        ProdutoCosif produtoCosif = new ProdutoCosif();
        produtoCosif.setPk(pk);

        List<ProdutoCosif> produtoCosifs = produtoCosifRepository.findAll(Example.of(produtoCosif));

        List<ProdutoCosifVO> produtoCosifVOList = new ArrayList<>();

        produtoCosifs.forEach(cosif -> produtoCosifVOList.add(
                ProdutoCosifVO.builder()
                        .codProduto(cosif.getPk().getCodProduto())
                        .codCosif(cosif.getPk().getCodCosif())
                        .codClassificacao(cosif.getCodClassificacao())
                        .build()
        ));

        return produtoCosifVOList;
    }
}
