package com.cg.pos.service.impl;

import java.sql.SQLException;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.pizza.dao.PizzaDetailsDao;
import com.cg.pos.pizza.dao.PizzaDetailsDaoImpl;
import com.cg.pos.pizza.dao1.IPizzaDetails;
import com.cg.pos.pizza.dao1.IPizzaDetailsDaoImpl;
import com.cg.pos.service.PizzaService;
import com.cg.pos.utility.Exceptions;
import com.cg.pos.utility.ValidatePizzaDetails;

public class PizzaServiceImpl implements PizzaService {

	ValidatePizzaDetails validatePizzaDetails = new ValidatePizzaDetails();
	PizzaDetailsDTO pizzaDetails;

	/**
	 * modifying name
	 * 
	 * @throws ValidateDetailsException
	 * @throws PizzaException
	 * @throws SQLException
	 */
	public String modifyName(int storeId, int pizzaId, String name) throws PizzaException {
		String result = "";

		if (validatePizzaDetails.isValidName(name)) {
			PizzaDetailsDao pizzaDao = new PizzaDetailsDaoImpl();
			result = pizzaDao.modifyName(storeId, pizzaId, name);
			if (result != "1") {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}
		}

		return result;

	}

	/**
	 * modifying Quantity
	 * 
	 * @throws PizzaException
	 * @throws SQLException
	 */

	@Override
	public String modifyQuantity(int storeId, int pizzaId, int quantity) throws PizzaException {
		String result = "";

		if (validatePizzaDetails.isValidQuantity(quantity) && validatePizzaDetails.isValidId(pizzaId)
				&& validatePizzaDetails.isValidStoreId(storeId)) {
			PizzaDetailsDao pizzaDao = new PizzaDetailsDaoImpl();
			result = pizzaDao.modifyQuantity(storeId, pizzaId, quantity);
			if (result != "1") {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}
		}
		
		

		return result;

	}

	/**
	 * modifying cost
	 * 
	 * @throws PizzaException
	 * @throws SQLException
	 */
	@Override
	public String modifyCost(int storeId, int pizzaId, double cost) throws PizzaException {
		String result = "";

		if (validatePizzaDetails.isValidCost(cost) && validatePizzaDetails.isValidId(pizzaId)
				&& validatePizzaDetails.isValidStoreId(storeId)) {
			PizzaDetailsDao pizzaDao = new PizzaDetailsDaoImpl();
			result = pizzaDao.modifyCost(storeId, pizzaId, cost);
			if (result != "1") {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}
		}

		return result;

	}

	/**
	 * modifying addOns
	 * 
	 * @throws PizzaException
	 * @throws SQLException
	 * 
	 * @throws InvalidAddOnsException
	 */
	@Override
	public String modifyAddOns(int storeId, int pizzaId, String addOns) throws PizzaException {

		String result = "";

		if (validatePizzaDetails.isValidAddOn(addOns) && validatePizzaDetails.isValidId(pizzaId)
				&& validatePizzaDetails.isValidStoreId(storeId)) {
			PizzaDetailsDao pizzaDao = new PizzaDetailsDaoImpl();
			result = pizzaDao.modifyAddOn(storeId, pizzaId, addOns);
			if (result != "1") {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}
		}

		return result;

	}

	/**
	 * deleting pizzaDetails
	 * @throws PizzaException 
	 * 
	 * @throws SQLException
	 * @throws ValidateDetailsException
	 */
	@Override
	public String deletePizzaDetails(PizzaDetailsDTO detailsDTO) throws PizzaException {
		String result = "";
		if (validatePizzaDetails.isValidId(detailsDTO.getItemId()) && validatePizzaDetails.isValidStoreId(detailsDTO.getStoreId())) {

			IPizzaDetails pizzaDao = new IPizzaDetailsDaoImpl();
			result = pizzaDao.delete(detailsDTO);
			if (result != "1") {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}

		}
		return result;

	}

	@Override
	public String modify(PizzaDetailsDTO detailsDTO) throws PizzaException {
		IPizzaDetails pizzaDao = new IPizzaDetailsDaoImpl();
		
		String result=pizzaDao.modify(detailsDTO);
		if(result!="1") {
			throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
		}
		
		
		return result;
	}
}
