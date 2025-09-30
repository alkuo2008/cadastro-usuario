package com.example.cadastro_pet.business;

import com.example.cadastro_pet.infrastructure.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cadastro_pet.infrastructure.entitys.Pet;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet cadastrarPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> buscarPetPorNome(String nome) {
        return petRepository.findByNome(nome);
    }

    public List<Pet> listarTodosPets() {
        return petRepository.findAll();
    }

    public void deletarPet(Integer id) {
        petRepository.deleteById(id);
    }

    public Pet atualizarPet(Integer id, Pet petAtualizado) {
        Optional<Pet> petExistente = petRepository.findById(id);
        if (petExistente.isPresent()) {
            Pet pet = petExistente.get();
            pet.setNome(petAtualizado.getNome());
            pet.setEspecie(petAtualizado.getEspecie());
            pet.setRaca(petAtualizado.getRaca());
            pet.setIdade(petAtualizado.getIdade());
            pet.setTutor(petAtualizado.getTutor());
            return petRepository.save(pet);
        } else {
            return null;
        }
    }
}
