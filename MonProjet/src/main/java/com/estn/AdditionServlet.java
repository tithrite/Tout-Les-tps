package com.estn;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class AdditionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Addition</title></head><body>");
        out.println("<h2 align='center'>Addition de deux nombres</h2>");
        out.println("<form method='POST' action='addition'>");
        out.println("<p align='center'>");
        out.println("Nombre 1: <input type='text' name='n1' size='10'> <br><br>");
        out.println("Nombre 2: <input type='text' name='n2' size='10'> <br><br>");
        out.println("<input type='submit' value='Additionner'>");
        out.println("</p>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        String s1 = request.getParameter("n1");
        String s2 = request.getParameter("n2");

        double n1 = 0, n2 = 0;
        boolean erreur = false;

        try {
            n1 = Double.parseDouble(s1);
            n2 = Double.parseDouble(s2);
        } catch (Exception e) {
            erreur = true;
        }

       
       
        if (!erreur) {
            out.println("<b>" + n1 + " + " + n2 + " = " + (n1 + n2) + "</b><br><br>");
        } else {
            out.println("<font color='red'>Veuillez entrer deux nombres valides.</font><br><br>");
        }

        
        out.println("<form method='POST' action='addition'>");
        out.println("Nombre 1: <input type='text' name='n1' size='10'> <br><br>");
        out.println("Nombre 2: <input type='text' name='n2' size='10'> <br><br>");
        out.println("<input type='submit' value='Additionner encore'>");
        out.println("</form>");

        out.println("</p>");
        out.println("</body></html>");
    }
}
