package br.com.psmcompany.produtocosif.repository;

import br.com.psmcompany.produtocosif.entity.MovimentoManual;
import br.com.psmcompany.produtocosif.entity.MovimentoManualPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualPk> {

}
