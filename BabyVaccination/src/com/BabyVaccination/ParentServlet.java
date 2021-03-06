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
@WebServlet("/ParentServlet")
public class ParentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
    	String username= request.getParameter("uname");
   		String password= request.getParameter("pass");
   		
   		POJO p=new POJO();
   		p.setUsername(username);
   		p.setPassword(password);
   		
   		ContainerService cs= new ContainerService();
   		Boolean result= cs.operation("parent");
   		
   		if(result)
   		{
   			response.sendRedirect("ParentWelcomePage.jsp");
   		}
   		else
   		{
   			out.println("Invalid Username and Password...Try Again");
   			RequestDispatcher rd = request.getRequestDispatcher("Parent.jsp");
   			rd.include(request, response);
   		}
	}

}
