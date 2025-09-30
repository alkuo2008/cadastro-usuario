package com.example.cadastro_pet.controller;

import com.example.cadastro_pet.business.PetService;
import com.example.cadastro_pet.infrastructure.entitys.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        return petService.cadastrarPet(pet);
    }

    @GetMapping("/{nome}")
    public Optional<Pet> buscarPet(@PathVariable String nome) {
        return petService.buscarPetPorNome(nome);
    }

    @GetMapping
    public List<Pet> listarTodos() {
        return petService.listarTodosPets();
    }

    @DeleteMapping("/{id}")
    public void deletarPet(@PathVariable Integer id) {
        petService.deletarPet(id);
    }

    @PutMapping("/{id}")
    public Pet atualizarPet(@PathVariable Integer id, @RequestBody Pet petAtualizado) {
        Pet pet = petService.atualizarPet(id, petAtualizado);
        if (pet != null) {
            return pet;
        } else {
            throw new RuntimeException("Pet não encontrado");
        }
    }
}
