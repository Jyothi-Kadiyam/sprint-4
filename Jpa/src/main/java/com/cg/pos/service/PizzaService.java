package com.cg.pos.service;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.PizzaException;

public interface PizzaService {

	//String modifyName(int storeId, int pizzaId, String name) throws PizzaException;

	String modifyQuantity(int storeId, int pizzaId, int quantity) throws PizzaException;

	String modifyCost(int storeId, int pizzaId, double cost) throws PizzaException;

	String modifyAddOns(int storeId, int pizzaId, String addOns) throws PizzaException;

	String deletePizzaDetails(PizzaDetailsDTO detailsDTO) throws PizzaException;

	String modify(PizzaDetailsDTO detailsDTO) throws PizzaException;

}
