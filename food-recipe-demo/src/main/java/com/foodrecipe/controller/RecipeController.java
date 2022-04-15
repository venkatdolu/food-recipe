package com.foodrecipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.foodrecipe.entity.RecipeDetails;
import com.foodrecipe.service.IRecipeDetailsService;

@RestController
public class RecipeController {

	@Autowired
	private IRecipeDetailsService recipeDetailsService;

	@GetMapping("/recipedetails/{id}")
	public ResponseEntity<RecipeDetails> getRecipeDetailsById(@PathVariable("id") Integer id) {
		RecipeDetails recipeDetails = recipeDetailsService.getRecipeDetailsById(id);
		return new ResponseEntity<RecipeDetails>(recipeDetails, HttpStatus.OK);
	}

	@GetMapping("/recipedetails")
	public ResponseEntity<List<RecipeDetails>> getAllRecipeDetails() {
		List<RecipeDetails> list = recipeDetailsService.getAllDetails();
		return new ResponseEntity<List<RecipeDetails>>(list, HttpStatus.OK);
	}

	@PostMapping("/addrecipedetails")
	public ResponseEntity<Void> addArticle(@RequestBody RecipeDetails recipeDetails, UriComponentsBuilder builder) {
		boolean flag = recipeDetailsService.addRecipeDetails(recipeDetails);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/recipedetails/{id}").buildAndExpand(recipeDetails.getReceipeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/updaterecipedetails")
	public ResponseEntity<RecipeDetails> updateRecipeDetails(@RequestBody RecipeDetails recipeDetails) {
		recipeDetailsService.updateRecipeDetails(recipeDetails);
		return new ResponseEntity<RecipeDetails>(recipeDetails, HttpStatus.OK);
	}

	@DeleteMapping("/recipedetails/{id}")
	public ResponseEntity<Void> deleteRecipeDetails(@PathVariable("id") Integer id) {
		recipeDetailsService.deleteRecipeDetails(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}