package br.com.psmcompany.produtocosif.resource;

import br.com.psmcompany.produtocosif.entity.MovimentoManual;
import br.com.psmcompany.produtocosif.model.MovimentoManualVO;
import br.com.psmcompany.produtocosif.service.ProdutoManualService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(
        value = "/api/produtos/{codProduto}/produtosCosif/{codCosif}/movimentosManuais",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class MovimentoManualController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovimentoManualController.class);

    @Autowired
    private ProdutoManualService produtoManualService;

    private static final String URI_MOVIMENTO_MANUAL = "http://localhost:8080/api" +
            "/produtos/{codProduto}/produtosCosif/{codCosif}/" +
            "movimentosManuais?datMes={datMes}&datAno={datAno}&numLancamento={numLancamento}";

    @GetMapping
    public ResponseEntity<List<MovimentoManualVO>> list(
            @PathVariable("codProduto") String codProduto,
            @PathVariable("codCosif") String codCosif) {
        return ResponseEntity.ok(produtoManualService.find(codProduto, codCosif));
    }

    @GetMapping("/{datMes}/{datAno}/{numLancamento}")
    public ResponseEntity<MovimentoManualVO> find(
            @PathVariable("codProduto") String codProduto,
            @PathVariable("codCosif") String codCosif,
            @PathVariable("datMes") String datMes,
            @PathVariable("datAno") String datAno,
            @PathVariable("numLancamento") String numLancamento ) {

        MovimentoManualVO movimentoManualVO = produtoManualService.find(
                codProduto,
                codCosif,
                datMes,
                datAno,
                numLancamento
        );

        if (movimentoManualVO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movimentoManualVO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insert(@RequestBody MovimentoManualVO movimentoManualVO)
    {
        LOGGER.info(String.format("Inserir %s", movimentoManualVO.toString()));

        MovimentoManual movimentoManual = produtoManualService.insert(movimentoManualVO);

        Map<String, String> uriVariables = new LinkedHashMap<>();
        uriVariables.put("codProduto", movimentoManual.getPk().getCodProduto());
        uriVariables.put("codCosif", movimentoManual.getPk().getCodCosif());
        uriVariables.put("datMes", movimentoManual.getPk().getDatMes().toString());
        uriVariables.put("datAno", movimentoManual.getPk().getDatAno().toString());
        uriVariables.put("numLancamento", movimentoManual.getPk().getNumLancamento().toString());

        URI location = new DefaultUriBuilderFactory().expand(URI_MOVIMENTO_MANUAL, uriVariables);

        return ResponseEntity.created(location).build();
    }

}
