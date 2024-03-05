package com.example.petmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petmanagementsystem.model.Pet;
import com.example.petmanagementsystem.repository.PetRepository;
import com.example.petmanagementsystem.services.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping("/addDetails")
	public ResponseEntity<Pet> addDetails(@RequestBody Pet pet) {
		Pet addPet = petService.savePet(pet);

		return new ResponseEntity<>(addPet, HttpStatus.CREATED);

	}

	@GetMapping("/getPets")
	public ResponseEntity<List<Pet>> getAllPet() {
		List<Pet> pets = petService.getAllpet();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@PutMapping("/updatePets/{id}")
	public String updatePet(@PathVariable int id, @RequestBody Pet petDetails) {
		Pet updatedPet = petService.updatePet(id, petDetails);
		return updatedPet != null ? "Updated Sucessfully" : "Pet Not found";
	}

	@DeleteMapping("/deletePets/{id}")
	public String deletePet(@PathVariable int id) {
		petService.deletePet(id);
		return "Pet deleted Sucessfully";

	}

}
