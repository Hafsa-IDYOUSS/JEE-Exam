package org.xproce.exam_1.dao.entities;

import jakarta.persistence .*;
import lombok .*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtCommande;

    @ManyToOne
    private Produit produit;
}