package com.example.petmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petmanagementsystem.model.Pet;
import com.example.petmanagementsystem.repository.PetRepository;

@Service
public class PetService {

	List<Pet> list;

	@Autowired
	private PetRepository petRepo;

	public List<Pet> getAllpet() {
		return petRepo.findAll();
	}

	public Pet savePet(Pet pet) {
		return petRepo.save(pet);
	}

	public Pet updatePet(int id, Pet petDetails) {
		Optional<Pet> optionalPet = petRepo.findById(id);
		if (optionalPet.isPresent()) {
			Pet pet = optionalPet.get();
			pet.setName(petDetails.getName());
			pet.setAge(petDetails.getAge());
			pet.setBreed(petDetails.getBreed());
			pet.setDescription(petDetails.getDescription());
			return petRepo.save(pet);
		} else {
			System.out.println("pet is not avaliable in the database");
			return null;
		}
	}

	public void deletePet(int id) {
		petRepo.deleteById(id);
	}

}
