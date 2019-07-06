package com.cg.pos.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.pos.exceptions.PizzaException;

public class ConnectionFactory {

	static Connection con=null;
	
	public static Connection getConnection() throws PizzaException {
		try {
		if(con==null||con.isClosed())
		{
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	    } catch (SQLException ex) {
	        throw new PizzaException("Something went wrong!!");
	    }
		}
		}catch (SQLException e) {
			throw new PizzaException("ERROR!!!");
		}
		return con;

}
}
