package org.xproce.exam_1.dao.entities;

import jakarta.persistence .*;
import lombok .*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Statuts statut;

    @ManyToOne
    private Client client;

    @OneToMany
    private List<LigneCommande> ligneCmd;

}