package com.foodrecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodrecipe.dao.IRecipeDetailsDao;
import com.foodrecipe.entity.RecipeDetails;

@Service
public class RecipeDetailsService implements IRecipeDetailsService {

	@Autowired
	private IRecipeDetailsDao recipeDetailsDao;

	@Override
	public List<RecipeDetails> getAllDetails() {
		return recipeDetailsDao.getAllDetails();
	}

	@Override
	public RecipeDetails getRecipeDetailsById(int recipeId) {
		return recipeDetailsDao.getRecipeDetailsById(recipeId);
	}

	@Override
	public boolean addRecipeDetails(RecipeDetails details) {
		recipeDetailsDao.addRecipeDetails(details);
		return true;
	}

	@Override
	public void updateRecipeDetails(RecipeDetails details) {
		recipeDetailsDao.updateRecipeDetails(details);
	}

	@Override
	public void deleteRecipeDetails(int recipeId) {
		recipeDetailsDao.deleteRecipeDetails(recipeId);
	}

}
