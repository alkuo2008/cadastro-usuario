package com.example.cadastro_pet.infrastructure.repository;

import com.example.cadastro_pet.infrastructure.entitys.Pet; // Ajuste aqui
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findByNome(String nome);
}
