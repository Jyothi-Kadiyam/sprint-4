package com.cg.pos.pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.utility.ConnectionFactory;
import com.cg.pos.utility.Exceptions;
import com.cg.pos.utility.Queries;

public class PizzaDetailsDaoImpl implements PizzaDetailsDao {

	PreparedStatement preparedStatement = null;
	Connection connection = null;

	@Override
	public String deletePizzaDetails(PizzaDetailsDTO detailsDTO) throws PizzaException {
		String result = "";
		try {
			connection = ConnectionFactory.getConnection();
			String sql = Queries.DELETE_ROW;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, detailsDTO.getItemId());
			preparedStatement.setInt(2, detailsDTO.getStoreId());
			int i = preparedStatement.executeUpdate();

			if (i == 1) {
				result = "1";
			}

		} catch (SQLException e) {
			throw new PizzaException(Exceptions.CONNECTIONERROR);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {

				throw new PizzaException(Exceptions.CONNECTIONERROR);
			}

		}

		return result;
	}

	public String modifyName(int storeId, int id, String name) throws PizzaException {
		String result = "";
		try {
			connection = ConnectionFactory.getConnection();
			String sql = Queries.MODIFY_NAME;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, storeId);
			int i = preparedStatement.executeUpdate();
			if (i == 1)
				result = "1";
			else {
				throw new PizzaException(Exceptions.INVALID_STOREID_AND_PIZZA_ID);
			}

		}

		catch (SQLException e) {
			throw new PizzaException(Exceptions.CONNECTIONERROR);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {

				throw new PizzaException(Exceptions.CONNECTIONERROR);
			}

		}

		return result;
	}

	@Override
	public String modifyQuantity(int storeId, int pizzaId, int quantity) throws PizzaException {
		String result = "";
		try {
			connection = ConnectionFactory.getConnection();
			String sql = Queries.MODIFY_QUANTITY;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, pizzaId);
			preparedStatement.setInt(3, storeId);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				result = "1";
			}

		} catch (SQLException e) {
			throw new PizzaException(Exceptions.CONNECTIONERROR);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {

				throw new PizzaException(Exceptions.CONNECTIONERROR);
			}

		}

		return result;
	}

	@Override
	public String modifyCost(int storeId, int pizzaId, double cost) throws PizzaException {
		String result = "";
		try {
			connection = ConnectionFactory.getConnection();
			String sql = Queries.MODIFY_COST;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, cost);
			preparedStatement.setInt(2, pizzaId);
			preparedStatement.setInt(3, storeId);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				result = "1";
			}
			connection.commit();
			preparedStatement.close();

		} catch (SQLException e) {
			throw new PizzaException(Exceptions.CONNECTIONERROR);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {

				throw new PizzaException(Exceptions.CONNECTIONERROR);
			}

		}

		return result;

	}

	@Override
	public String modifyAddOn(int storeId, int pizzaId, String addOns) throws PizzaException {
		String result = "";
		try {
			connection = ConnectionFactory.getConnection();
			String sql = Queries.MODIFY_ADDON;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addOns);
			preparedStatement.setInt(2, pizzaId);
			preparedStatement.setInt(3, storeId);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				result = "1";
			}

		} catch (SQLException e) {
			throw new PizzaException(Exceptions.CONNECTIONERROR);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {

				throw new PizzaException(Exceptions.CONNECTIONERROR);
			}

		}

		return result;
	}

	
}
