package com.mina.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UniteOfMeasure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String uom;
	
	@OneToOne(cascade = CascadeType.DETACH )
	private Ingredient ingredient;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	
	

}
