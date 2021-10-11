package br.com.psmcompany.produtocosif.resource;

import br.com.psmcompany.produtocosif.model.ProdutoCosifVO;
import br.com.psmcompany.produtocosif.service.ProdutoCosifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProdutoCosifController {

    @Autowired
    private ProdutoCosifService produtoCosifService;

    @GetMapping("/produtos/{codProduto}/produtosCosif")
    public ResponseEntity<List<ProdutoCosifVO>> produtosCosif(@PathVariable("codProduto") String codProduto)
    {
        return ResponseEntity.ok(produtoCosifService.findProdutosCosif(codProduto));
    }

}
