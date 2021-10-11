package br.com.psmcompany.produtocosif.repository;

import br.com.psmcompany.produtocosif.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
