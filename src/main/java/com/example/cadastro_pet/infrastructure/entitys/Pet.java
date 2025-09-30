package com.example.cadastro_pet.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "especie")
    private String especie;

    @Column(name = "raca")
    private String raca;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "tutor")
    private String tutor;
}
