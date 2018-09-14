package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class testClass {

	public static void main(String[] args) throws SQLException {
		Database.getInstance();
		
		ResultSet returnValue = Database.queryStatement("Select * from products where productID = '1'");
		
		if(returnValue.next() == false)
			System.out.println("BROKEN");
	}
	
}
