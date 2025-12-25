package org.xproce.exam_1.dao.entities;

import jakarta.persistence .*;
import lombok .*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Float prix;
    private Integer quantite;
}
