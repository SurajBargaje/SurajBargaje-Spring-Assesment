package com.example.petmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petmanagementsystem.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
