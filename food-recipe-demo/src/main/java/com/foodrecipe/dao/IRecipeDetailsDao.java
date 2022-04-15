package com.foodrecipe.dao;

import java.util.List;

import com.foodrecipe.entity.RecipeDetails;

public interface IRecipeDetailsDao {

	List<RecipeDetails> getAllDetails();

	RecipeDetails getRecipeDetailsById(int recipeId);

	void addRecipeDetails(RecipeDetails details);

	void updateRecipeDetails(RecipeDetails details);

	void deleteRecipeDetails(int recipeId);

}
