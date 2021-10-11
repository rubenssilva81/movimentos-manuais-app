package br.com.psmcompany.produtocosif.resource;

import br.com.psmcompany.produtocosif.model.ProdutoVO;
import br.com.psmcompany.produtocosif.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoVO>> produtos()
    {
        return ResponseEntity.ok(produtoService.findAll());
    }
}

