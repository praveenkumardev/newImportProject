package com.BabyVaccination;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BabyVaccination.Service.ContainerService;
import com.BabyVaccination.model.POJO;

@WebServlet("/AdminServ")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
   		String username= request.getParameter("uname");
   		String password= request.getParameter("pass");
   		System.out.println("User :"+username +"Pass :"+password);
   		
   		POJO p=new POJO();
   		p.setUsername(username);
   		p.setPassword(password);
   		System.out.println("getUser :"+p.getUsername()+"getPass :"+p.getPassword());
   		ContainerService cs= new ContainerService();
   		Boolean result= cs.operation("admin");
   		
   		if(result)
   		{
   			out.println("valid Username and Password...Try Again");
   			response.sendRedirect("AdminWelcomePage.jsp");
   		}
   		else
   		{
   			out.println("Invalid Username and Password...Try Again");
   			RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
   			rd.include(request, response);
   		}
	}

}

