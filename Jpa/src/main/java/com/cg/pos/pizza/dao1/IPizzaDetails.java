package com.cg.pos.pizza.dao1;

import com.cg.pos.entity.PizzaDetailsDTO;

public interface IPizzaDetails {

	String delete(PizzaDetailsDTO detailsDTO);

	String modify(PizzaDetailsDTO detailsDTO);

}
