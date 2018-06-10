package com.mina.domain;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String  description;
	private BigDecimal amount;
	
	@OneToOne
	private UniteOfMeasure uniteOfMeasure;
	@ManyToOne
	private Recipe recipe;

	public UniteOfMeasure getUniteOfMeasure() {
		return uniteOfMeasure;
	}

	public void setUniteOfMeasure(UniteOfMeasure uniteOfMeasure) {
		this.uniteOfMeasure = uniteOfMeasure;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	

}
