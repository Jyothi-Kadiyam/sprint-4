package com.cg.pos.pizza.dao;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.PizzaException;

public interface PizzaDetailsDao {


	public String modifyName(int storeId,int id, String name) throws PizzaException;

	public String modifyQuantity(int storeId, int pizzaId, int quantity) throws PizzaException ;

	public String modifyCost(int storeId, int pizzaId, double cost) throws PizzaException;

	public String modifyAddOn(int storeId, int pizzaId, String addOns) throws PizzaException;

	String deletePizzaDetails(PizzaDetailsDTO detailsDTO) throws PizzaException;

	

}
