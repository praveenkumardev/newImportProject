package com.BabyVaccination.DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataAcessObject {

	
	public Connection connectionMethod()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "123");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
}
