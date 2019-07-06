package com.cg.pos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
@NamedQueries({
		
		@NamedQuery(name ="MODIFY_QUANTITY", query = "update PizzaDetailsDTO p set p.quantity=? where p.itemId=? and p.storeId=?"),
		@NamedQuery(name ="MODIFY_COST", query = "update PizzaDetailsDTO p set p.cost=? where p.itemId=? and p.storeId=?"),
		//@NamedQuery(name ="DELETE_ROW", query = "delete from pizza p where p.itemId=? and p.storeId=?"),
		@NamedQuery(name ="MODIFY_NAME", query = "update PizzaDetailsDTO p set p.itemName=? where p.itemId=? and p.storeId=?")})

public class PizzaDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int itemId;
	private int storeId;
	@Column(name = "pizzaname")
	private String itemName;
	private int quantity;
	@Column(name = "price")
	private double cost;
	private String addOns;

	public PizzaDetailsDTO() {

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public PizzaDetailsDTO(int itemId, int storeId, String itemName, int quantity, double cost, String addOns) {

		this.itemId = itemId;
		this.storeId = storeId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
		this.addOns = addOns;
	}

	@Override
	public String toString() {
		return "PizzaDetails [itemId=" + itemId + ",storeId=" + storeId + ", itemName=" + itemName + ", quantity="
				+ quantity + ", cost=" + cost + ", addOns=" + addOns + "]" + '\n';
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getAddOns() {
		return addOns;
	}

	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
