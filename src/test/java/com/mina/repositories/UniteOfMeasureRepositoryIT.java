package com.mina.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mina.domain.UniteOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UniteOfMeasureRepositoryIT {

	@Autowired
	UniteOfMeasureRepository uniteOfMeasureRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByUom() {
		Optional<UniteOfMeasure> findByUom = uniteOfMeasureRepository.findByUom("Teaspoon");
		assertEquals("Teaspoon", findByUom.get().getUom());
	}
	
	@Test
	public void testFindByUomCup() {
		Optional<UniteOfMeasure> findByUom = uniteOfMeasureRepository.findByUom("Cup");
		assertEquals("Cup", findByUom.get().getUom());
	}

}
