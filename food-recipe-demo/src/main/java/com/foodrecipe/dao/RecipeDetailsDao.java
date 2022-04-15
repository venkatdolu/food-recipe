package com.foodrecipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodrecipe.entity.RecipeDetails;

@Transactional
@Repository
public class RecipeDetailsDao implements IRecipeDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RecipeDetails getRecipeDetailsById(int recipeId) {
		return entityManager.find(RecipeDetails.class, recipeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeDetails> getAllDetails() {
		String hql = "FROM RecipeDetails as rd ORDER BY rd.receipeId";
		return (List<RecipeDetails>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addRecipeDetails(RecipeDetails details) {
		entityManager.persist(details);
	}

	@Override
	public void updateRecipeDetails(RecipeDetails details) {
		RecipeDetails existDetails = getRecipeDetailsById(details.getReceipeId());
		existDetails.setName(details.getName());
		existDetails.setIngradiants(details.getIngradiants());
		existDetails.setSteps(details.getSteps());
		entityManager.flush();
	}

	@Override
	public void deleteRecipeDetails(int recipeId) {
		entityManager.remove(getRecipeDetailsById(recipeId));
	}

}
