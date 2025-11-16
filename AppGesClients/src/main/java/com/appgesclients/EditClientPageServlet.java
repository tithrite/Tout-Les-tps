package com.appgesclients;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/EditClientPageServlet")
public class EditClientPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.sendRedirect("ListClientsServlet");
            return;
        }

        int clientId = Integer.parseInt(idStr);
        Client client = null;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM clients WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    
                    rs.getString("prenom"),
                    
                    rs.getInt("age")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }

        if (client == null) {
            response.sendRedirect("ListClientsServlet");
            return;
        }

        request.setAttribute("client", client);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editClient.jsp");
        dispatcher.forward(request, response);
    }
}
