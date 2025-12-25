package org.xproce.exam_1.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.xproce.exam_1.dao.entities.Commande;
import org.xproce.exam_1.dao.entities.LigneCommande;
import org.xproce.exam_1.sevice.CommandeServiceImpl;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByClientId(Long clientId);
    Commande save(Long clientId, List<LigneCommande> lignesCommande);

    LigneCommande findByLigneCmd(List<LigneCommande> ligneCmd);

    List<Commande> getCommandesByLigneCmd(List<LigneCommande> ligneCmd);

    Commande getCommandesById(CommandeServiceImpl commandeService);
}