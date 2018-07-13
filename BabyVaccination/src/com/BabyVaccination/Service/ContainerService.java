package com.BabyVaccination.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.BabyVaccination.model.POJO;
import com.BabyVaccination.DAO.DataAcessObject;


public class ContainerService {
	
	Connection con;
	Statement st;
	boolean check=false;
	String sql;
	ResultSet rs;
	public static void main(String s[])
	{
		POJO p2=new POJO();
		System.out.println("main method "+p2.getPassword());
		System.out.println("main method "+p2.getUsername());
	}
	public boolean operation(String input)
	{
		
		DataAcessObject dao=new DataAcessObject();
		con=dao.connectionMethod();
		
		POJO p1=new POJO();
   		String username=p1.getUsername();
   		String password=p1.getPassword();
   		System.out.println("servicegetUser :"+p1.getUsername()+"getPass :"+p1.getPassword());
		if(input.equals("admin"))
		{
			try
			{
				sql= "select adminId, password from Admin";
				st=con.createStatement();
				rs= st.executeQuery(sql);
				while(rs.next())
				{
					System.out.println("table result :"+rs.getString(1)+":"+rs.getString(2));
					System.out.println("input result :"+username+":"+password);
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						check=true;
					}else
					{
						System.out.println("Else condition");
					}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(input.equals("hospital"))
		{
			try
			{
				sql= "select employeeId, password from hospitaladmindetail";
				st=con.createStatement();
				rs= st.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						check=true;
					}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}else
		{
			try
			{
				sql= "select babyId, password from babyparentdetail";
				st=con.createStatement();
				rs= st.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						check=true;
					}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return check;
	}

}
