package org.xproce.exam_1.dao.entities;

import jakarta.persistence .*;
import lombok .*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String nom;
    private String email;
    private String adresse;
}