package com.mina.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Recipe recipe;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public String getRecipNotes() {
		return recipNotes;
	}
	public void setRecipNotes(String recipNotes) {
		this.recipNotes = recipNotes;
	}
	private String recipNotes;
}
