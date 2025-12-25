package org.xproce.exam_1.sevice;

import org.xproce.exam_1.dao.entities.Commande;
import org.xproce.exam_1.dao.entities.LigneCommande;
import java.util.List;

public interface ICommandeService {
    void updateProductStock(Long productId, int quantityChange);
    Commande passerCommande(Long clientId, List<LigneCommande> lignesCommande);
    List<Commande> getCommandesByClient(Long clientId);
}


