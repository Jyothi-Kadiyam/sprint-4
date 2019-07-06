package com.cg.pos.utility;

import com.cg.pos.exceptions.*;

public class ValidatePizzaDetails {

	/**
	 * Validating the pizzaName.
	 * 
	 * @param quantity
	 * @return
	 * @throws InvalidItemNameException
	 * @throws ValidateDetailsException
	 */
	public boolean isValidName(String name) throws PizzaException {

		if (!name.matches("[a-z A-Z]+{1,25}")) {

			throw new PizzaException(Exceptions.INVALID_PIZZANAME);
		}
		return true;
	}

	/**
	 * Validating StoreName
	 * 
	 * @param storeName
	 * @return
	 * @throws ValidateDetailsException
	 * @throws InvalidStoreNameException
	 *             //
	 */
	public boolean isValidStoreId(int storeId) throws  PizzaException {
		String tempStoreId = Integer.toString(storeId);
		if (!tempStoreId.matches("[0-9]+")) {

			throw new PizzaException(Exceptions.INVALID_STOREID);
		}
		return true;
	}

	/**
	 * Validating Quantity
	 * 
	 * @param quantity
	 * @return
	 * @throws InvalidItemQuantityException
	 * @throws ValidateDetailsException
	 */
	public boolean isValidQuantity(int quantity) throws PizzaException {
		String stringQuantity = Integer.toString(quantity);
		if (!stringQuantity.matches("[0-9]{1,5}") || quantity <= 0) {
			throw new PizzaException(Exceptions.INVALID_QUANTITY);

		}

		return true;
	}

	/**
	 * validating Id
	 * 
	 * @param id
	 * @return
	 * @throws InvalidItemIdException
	 * @throws ValidateDetailsException
	 */
	public boolean isValidId(int id) throws PizzaException {
		String stringId = Integer.toString(id);
		if (!stringId.matches("[0-9]+{1,5}")) {

			throw new PizzaException(Exceptions.INVALID_ID);

		}

		return true;
	}

	/**
	 * Validating Cost
	 * 
	 * @param cost
	 * @return
	 * @throws InvalidItemCostException
	 * @throws ValidateDetailsException
	 */

	public boolean isValidCost(double cost) throws PizzaException {
		String stringCost = Double.toString(cost);
		if (stringCost.isEmpty() || cost <= 0.0 || stringCost.matches("[A-Z a-z]")) {
			throw new PizzaException(Exceptions.INVALID_COST);

		}
		return true;

	}

	/**
	 * Validating Addons
	 * 
	 * @param addOns
	 * @return
	 * @throws InvalidAddOnsException
	 * @throws ValidateDetailsException
	 */

	public boolean isValidAddOn(String addOns) throws PizzaException {
		if (!addOns.matches("[A-Z a-z]+{1,30}")) {

			throw new PizzaException(Exceptions.INVALID_ADDON);
		}
		return true;
	}

	
}
