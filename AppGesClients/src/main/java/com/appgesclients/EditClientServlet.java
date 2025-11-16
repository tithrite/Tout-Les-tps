package com.appgesclients;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/EditClientServlet")
public class EditClientServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException {
		
		int id= Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		
		String prenom=request.getParameter("prenom");
		int age  = Integer.parseInt(request.getParameter("age"));

		
		 try (Connection conn = DBConnection.getConnection()) {
	            String sql = "UPDATE clients SET nom = ?, prenom = ?, age = ? WHERE id = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, nom);
	            ps.setString(2, prenom);
	            ps.setInt(3, age);
	            ps.setInt(4, id);

	            ps.executeUpdate();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("ListClientsServlet");
	    }
	}
