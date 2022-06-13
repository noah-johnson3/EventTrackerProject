package com.skilldistillery.diet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.diet.entities.DietTracking;

public interface DietTrackerRepository extends JpaRepository<DietTracking, Integer> {
	


}
