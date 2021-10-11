package br.com.psmcompany.produtocosif.service;

import br.com.psmcompany.produtocosif.entity.Produto;
import br.com.psmcompany.produtocosif.model.ProdutoVO;
import br.com.psmcompany.produtocosif.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ProdutoVO> findAll() {

        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoVO> produtoVOList = new ArrayList<>();
        produtos.forEach(produto -> produtoVOList.add(
                ProdutoVO.builder()
                        .codProduto(produto.getCodProduto())
                        .desProduto(produto.getDesProduto())
                        .build()
        ));

        return produtoVOList;
    }
}
