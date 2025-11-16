package com.estn.controller;

import com.estn.metier.EmployeService;
import com.estn.dao.EmployeDaoImpl;
import com.estn.model.Employe;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculerPrime")
public class PrimeServiceController extends HttpServlet {

    private EmployeService service;

    @Override
    public void init() throws ServletException {
    	
        try {
        	
          
            EmployeDaoImpl dao = new EmployeDaoImpl();  
            service = new EmployeService();            
            service.setEmployeDao(dao); 
            
            

        } catch (Exception e) {
        	
            e.printStackTrace();
            
            throw new ServletException("Erreur init service: " + e.getMessage(), e);
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    
              throws ServletException, IOException {

       
    	
    try {
            int id = Integer.parseInt(request.getParameter("id"));

            Employe employe = service.getEmployeById(id);

            if (employe == null) {
                request.setAttribute("error", "Employé avec ID " + id + " n'existe pas!");
                request.getRequestDispatcher("calculerPrime.jsp").forward(request, response);
                return;
            }

          
            LocalDate today = LocalDate.now();
            int experience = Period.between(employe.getDateEmbauche(), today).getYears();

            double prime = (employe.getSalaire() * 0.10) + (experience * 500);
            
            

            request.setAttribute("employe", employe);
            
            request.setAttribute("experience", experience);
            request.setAttribute("prime", prime);

            request.getRequestDispatcher("resultatPrime.jsp").forward(request, response);

            
        } catch (NumberFormatException ex) {
        	
            request.setAttribute("error", "ID invalide!");
            request.getRequestDispatcher("calculerPrime.jsp").forward(request, response);
        }
    }
}
