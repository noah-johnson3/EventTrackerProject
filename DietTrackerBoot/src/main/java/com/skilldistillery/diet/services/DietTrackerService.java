package com.skilldistillery.diet.services;

import java.util.List;

import com.skilldistillery.diet.entities.DietTracking;

public interface DietTrackerService {
	
	public List<DietTracking> index();
	public DietTracking show(int id);
	public DietTracking create(DietTracking diets);
	public DietTracking update(int id, DietTracking diet);
	public boolean delete(int id);
	

}
