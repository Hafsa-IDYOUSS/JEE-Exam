package org.xproce.exam_1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xproce.exam_1.dao.entities.LigneCommande;
import org.xproce.exam_1.dao.repositories.ProduitRepository;
import org.springframework.ui.Model;
import org.xproce.exam_1.sevice.ICommandeService;

import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {

    private final ICommandeService commandeService;
    private final ProduitRepository produitRepository;

    public CommandeController(ICommandeService commandeService,
                              ProduitRepository produitRepository) {
        this.commandeService = commandeService;
        this.produitRepository = produitRepository;
    }

    @GetMapping("/new")
    public String formCommande(Model model) {
        model.addAttribute("produits", produitRepository.findAll());
        return "commande-form";
    }

    @PostMapping
    public String passerCommande(@RequestParam Long clientId,
                                 @RequestParam Long produitId,
                                 @RequestParam int quantite) {

        LigneCommande ligne = new LigneCommande();
        ligne.setProduit(produitRepository.findById(produitId).orElseThrow());
        ligne.setQtCommande(quantite);

        commandeService.passerCommande(clientId, List.of(ligne));

        return "redirect:/commandes?clientId=" + clientId;
    }

    @GetMapping
    public String commandesClient(@RequestParam Long clientId, Model model) {
        model.addAttribute("commandes", commandeService.getCommandesByClient(clientId));
        model.addAttribute("clientId", clientId);
        return "commandes";
    }
}
