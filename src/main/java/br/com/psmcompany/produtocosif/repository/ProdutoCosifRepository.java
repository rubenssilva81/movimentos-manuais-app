package br.com.psmcompany.produtocosif.repository;

import br.com.psmcompany.produtocosif.entity.ProdutoCosif;
import br.com.psmcompany.produtocosif.entity.ProdutoCosifPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
ProdutoCosifRepository extends JpaRepository<ProdutoCosif, ProdutoCosifPk> {

}
