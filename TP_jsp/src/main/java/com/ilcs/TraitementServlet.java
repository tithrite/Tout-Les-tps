package com.ilcs;

import com.ilcs.Etudiant;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/TraitementServlet")
public class TraitementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setCharacterEncoding("UTF-8");

       
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

       
        Random rand = new Random();
        double note = Math.round(rand.nextDouble() * 20 * 100.0) / 100.0; 

      
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setNote(note);

        
        request.setAttribute("etudiant", etudiant);

        
        RequestDispatcher rd = request.getRequestDispatcher("reponse.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
