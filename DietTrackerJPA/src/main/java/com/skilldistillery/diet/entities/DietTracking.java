package com.skilldistillery.diet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diet_tracking")
public class DietTracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int calories;
	
	
	private int protein;
	
	private int carb;

	private int fat;
	
	private String name;

	public DietTracking() {
		super();
	}

	public DietTracking(int id, int calories, int protein, int carb, int fat, String name) {
		super();
		this.id = id;
		this.calories = calories;
		this.protein = protein;
		this.carb = carb;
		this.fat = fat;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarb() {
		return carb;
	}

	public void setCarb(int carb) {
		this.carb = carb;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DietTracking other = (DietTracking) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "DietTracking [id=" + id + ", calories=" + calories + ", protein=" + protein + ", carb=" + carb
				+ ", fat=" + fat + ", name=" + name + "]";
	}
	
}