package com.skilldistillery.diet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.diet.entities.DietTracking;
import com.skilldistillery.diet.repositories.DietTrackerRepository;


@Service
public class DietTrackerServiceImpl implements DietTrackerService {

	@Autowired
	private DietTrackerRepository dietRepo;

	@Override
	public List<DietTracking> index() {
		return dietRepo.findAll();
	}

	@Override
	public DietTracking show(int id) {
		DietTracking diet = null;
		Optional<DietTracking> dietOpt = dietRepo.findById(id);
		if(dietOpt.isPresent()) {
			diet = dietOpt.get();
		}
		return diet;
	}

	@Override
	public DietTracking create(DietTracking diet) {
		diet = dietRepo.saveAndFlush(diet);
		return diet;
	}

	@Override
	public DietTracking update(int id, DietTracking diet) {
		Optional<DietTracking> dietOp = dietRepo.findById(id);
		if(dietOp.isPresent()) {
			diet.setId(id);
			dietRepo.saveAndFlush(diet);
		} else {
			diet = null;
		}
		return diet;
	}

	@Override
	public boolean delete(int id) {
		boolean isDeleted = false;
		Optional<DietTracking> dietOp = dietRepo.findById(id);
		if(dietOp.isPresent()) {
			dietRepo.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}
}
