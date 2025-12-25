package org.xproce.exam_1.sevice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xproce.exam_1.dao.entities.Commande;
import org.xproce.exam_1.dao.entities.LigneCommande;
import org.xproce.exam_1.dao.entities.Produit;
import org.xproce.exam_1.dao.repositories.CommandeRepository;
import org.xproce.exam_1.dao.repositories.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommandeServiceImpl implements ICommandeService {
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository, ProduitRepository produitRepository) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public Commande passerCommande(Long clientId, List<LigneCommande> lignesCommande){
        if(clientId != null &&  lignesCommande != null){
            return  commandeRepository.save(clientId, lignesCommande);
        }
        return null;
    }

    @Override
    public List<Commande> getCommandesByClient(Long clientId) {
        if(clientId != null){
            return commandeRepository.findByClientId(clientId);
        }
        return null;
    }

    @Override
    public void updateProductStock(Long productId, int quantityChange) {
        Optional<Produit> oproduit = produitRepository.findById(productId);
        if(oproduit.isPresent()){
            Produit produit = oproduit.get();
            if (quantityChange > 0 && quantityChange <= produit.getQuantite()) {
                int nvStock = produit.getQuantite() - quantityChange;
                produit.setQuantite(nvStock);
            }
        }
    }
}





//    @Override
//    public void updateProductStock(Long productId, int quantityChange) {
//        Commande cmd = commandeRepository.getCommandesById(this);
//        Produit produit = null;
//
//        for (LigneCommande ligneCommande : cmd.getLigneCmd()) {
//            if (ligneCommande.getProduit().getId() == productId) {
//                produit = ligneCommande.getProduit();
//                break;
//            }
//        }
//        Produit produit = ligneCmdRepository.findByProductId(productId);
//        if (produit != null && quantityChange > 0 && quantityChange <= produit.getQuantite()) {
//            int nvStock = produit.getQuantite() - quantityChange;
//            produit.setQuantite(nvStock);
//        }
//    }