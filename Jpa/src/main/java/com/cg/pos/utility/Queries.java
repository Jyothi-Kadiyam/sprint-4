package com.cg.pos.utility;

public class Queries {

	public static final String RETRIVE_STORE_NAME_QUERY = "select storeId,itemId from pizza where itemId=? and storeId=?";
	public static final String DELETE_ROW = "delete from pizza where itemId=? and storeId=?";
	public static final String MODIFY_NAME = "update pizza set itemname=? where itemId=? and storeId=?";
	public static final String MODIFY_QUANTITY = "update pizza set quantity=? where itemId=? and storeId=?";
	public static final String MODIFY_COST = "update pizza set price=? where itemId=? and storeId=?";
	public static final String MODIFY_ADDON = "update pizza set addons=? where itemId=? and storeId=?";

}
