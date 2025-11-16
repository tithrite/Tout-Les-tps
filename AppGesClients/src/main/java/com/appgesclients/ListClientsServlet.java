package com.appgesclients;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet; 

@WebServlet("/ListClientsServlet")

public class ListClientsServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) 
	throws ServletException , IOException {
		
		List<Client> clients= new ArrayList<>();
		String searchbyname=request.getParameter("nom");
		
		
		try ( Connection conn = DBConnection.getConnection() ){
			System.out.println("Nom recherché: " + searchbyname);

			String sql;
			
			 if (searchbyname != null && !searchbyname.trim().isEmpty()) {
		            sql = "SELECT * FROM clients WHERE nom LIKE ?";
		        } else {
		            sql = "SELECT * FROM clients";
		        }
			 
			 
			  PreparedStatement stmt = conn.prepareStatement(sql);
		        if (searchbyname != null && !searchbyname.trim().isEmpty()) {
		            stmt.setString(1, "%" + searchbyname + "%");
		        }
		        
			
			
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		            Client c = new Client(
		                rs.getInt("id"),
		                rs.getString("nom"),
		                rs.getString("prenom"),
		                rs.getInt("age")
		            );
		            clients.add(c);
		        }
			
			
			
			
			rs.close();
			stmt.close();
			
		} catch ( SQLException e ) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		request.setAttribute("clients", clients);
		
	    RequestDispatcher dispatcher= request.getRequestDispatcher("listClients.jsp");
	    dispatcher.forward(request, response);
		
	
		
	}
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
