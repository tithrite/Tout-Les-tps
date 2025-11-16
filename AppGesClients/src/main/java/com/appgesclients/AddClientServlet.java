package com.appgesclients;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/AddClientServlet")
public class AddClientServlet extends HttpServlet  {
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response ) 
		throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String Prenom = request.getParameter("prenom");
		int  age = Integer.parseInt(request.getParameter("age"));
		
		
		try( Connection conn = DBConnection.getConnection()){
			 
			String  sql= "INSERT INTO clients (nom , prenom , age ) VALUES (?,?,? ) ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nom);
			ps.setString(2, Prenom);
			ps.setInt(3, age);
			
			
			ps.executeUpdate();
			ps.close();
			
			
		}catch (SQLException e){
			
			 e.printStackTrace();
		}
		
		response.sendRedirect("ListClientsServlet");
	}
		
	
	

}
