package br.com.psmcompany.produtocosif.service;

import br.com.psmcompany.produtocosif.entity.MovimentoManual;
import br.com.psmcompany.produtocosif.entity.MovimentoManualPk;
import br.com.psmcompany.produtocosif.model.MovimentoManualVO;
import br.com.psmcompany.produtocosif.repository.MovimentoManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProdutoManualService {

    @Autowired
    private MovimentoManualRepository movimentoManualRepository;

    public List<MovimentoManualVO> find(String codProduto, String codCosif)
    {
        MovimentoManualPk pk = new MovimentoManualPk();
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setPk(pk);
        pk.setCodProduto(codProduto);
        pk.setCodCosif(codCosif);

        List<MovimentoManual> movimentoManualList = movimentoManualRepository.findAll(Example.of(movimentoManual));

        List<MovimentoManualVO> movimentoManualVOList = new ArrayList<>();
        movimentoManualList.forEach(mm -> movimentoManualVOList.add(MovimentoManualVOAdapter.adapt(mm)));

        return movimentoManualVOList;
    }

    public MovimentoManualVO find(String codProduto,
                                  String codCosif,
                                  String datMes,
                                  String datAno,
                                  String numLancamento) {

        MovimentoManualVO result = null;

        MovimentoManualPk pk = new MovimentoManualPk();
        pk.setCodProduto(codProduto);
        pk.setCodCosif(codCosif);
        pk.setDatAno(Integer.valueOf(datAno));
        pk.setDatMes(Integer.valueOf(datMes));
        pk.setDatMes(Integer.valueOf(numLancamento));

        Optional<MovimentoManual> optionalMovimentoManual = movimentoManualRepository.findById(pk);
        if (optionalMovimentoManual.isPresent()) {
             result = MovimentoManualVOAdapter.adapt(optionalMovimentoManual.get());
        }

        return result;
    }

    public MovimentoManual insert(MovimentoManualVO movimentoManualVO)
    {
        MovimentoManualPk pk = new MovimentoManualPk();
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setPk(pk);
        pk.setCodProduto(movimentoManualVO.getCodProduto());
        pk.setCodCosif(movimentoManualVO.getCodCosif());
        pk.setDatAno(movimentoManualVO.getDatAno());
        pk.setDatMes(movimentoManualVO.getDatMes());
        pk.setNumLancamento(obterUltimoLancamento(movimentoManualVO));
        movimentoManual.setDatMovimento(new Date());
        movimentoManual.setCodUsuario("TESTE");
        movimentoManual.setDesDescricao(movimentoManualVO.getDesDescricao());
        movimentoManual.setValValor(movimentoManualVO.getValValor());

        return movimentoManualRepository.save(movimentoManual);
    }

    private int obterUltimoLancamento(MovimentoManualVO movimentoManualVO)
    {
        MovimentoManualPk pk = new MovimentoManualPk();
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setPk(pk);
        pk.setCodProduto(movimentoManualVO.getCodProduto());
        pk.setCodCosif(movimentoManualVO.getCodCosif());
        pk.setDatAno(movimentoManualVO.getDatAno());
        pk.setDatMes(movimentoManualVO.getDatMes());

        List<MovimentoManual> movimentoManualList = movimentoManualRepository.findAll(Example.of(movimentoManual));

        Optional<MovimentoManual> optionalMovimentoManual = movimentoManualList
                .stream()
                .max(Comparator.comparing(o -> o.getPk().getNumLancamento()));

        return optionalMovimentoManual.map(manual -> manual.getPk().getNumLancamento() + 1).orElse(1);
    }

}
