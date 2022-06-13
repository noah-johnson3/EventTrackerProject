package com.skilldistillery.diet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.diet.entities.DietTracking;
import com.skilldistillery.diet.services.DietTrackerService;

@RestController
@RequestMapping("api")
public class DietTrackerController {

	@Autowired
	private DietTrackerService dietSvc;

	@GetMapping("diet/{id}")
	public DietTracking show(@PathVariable int id, HttpServletResponse resp) {
		DietTracking diet = dietSvc.show(id);
		if (diet != null) {
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return diet;
	}

	@GetMapping("diet")
	public List<DietTracking> index(HttpServletResponse resp) {
		List<DietTracking> diets = dietSvc.index();
		return diets;
	}

	@PostMapping("diet")
	public DietTracking create(@RequestBody DietTracking diet, HttpServletResponse resp, HttpServletRequest req) {
		DietTracking newDiet = null;
		try {
			newDiet = dietSvc.create(diet);
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.setHeader("location", req.getRequestURI() + "/" + newDiet.getId());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return newDiet;
	}

	@PutMapping("diet/{id}")
	public DietTracking update(@RequestBody DietTracking diet, @PathVariable int id, HttpServletResponse resp,
			HttpServletRequest req) {
		dietSvc.update(id, diet);
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setHeader("location", req.getRequestURI() + "/" + diet.getId());
		return diet;
	}

	@DeleteMapping("diet/{id}")
	public void delete(@PathVariable int id, HttpServletResponse res) {
		try {
			if (dietSvc.delete(id)) {
				res.setStatus(HttpServletResponse.SC_OK);
			} else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
