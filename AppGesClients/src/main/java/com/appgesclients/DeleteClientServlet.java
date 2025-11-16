package com.appgesclients;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/deleteClient")
public class DeleteClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int clientId = Integer.parseInt(idStr);
            

            try (Connection conn = DBConnection.getConnection()) {
            	
                String sql = "DELETE FROM clients WHERE id = ?";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, clientId);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

     
        response.sendRedirect("ListClientsServlet");
    }
}
