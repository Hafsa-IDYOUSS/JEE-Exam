package org.xproce.exam_1.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.exam_1.dao.entities.LigneCommande;
import org.xproce.exam_1.dao.entities.Produit;

public interface LigneCmdRepository extends JpaRepository<LigneCommande, Long> {
    Produit findByProductId(Long productId);
}
