package beans;

import beans.Etudiant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TraitementServlet")
public class TraitementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        
        Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
        if (etudiant == null) {
            etudiant = new Etudiant();  // Si le bean n'existe pas, le créer
        }

        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        
        System.out.println("Nom reçu : " + nom);
        System.out.println("Prénom reçu : " + prenom);

       
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);

       
        etudiant.genererNoteAleatoire();

        
        request.setAttribute("etudiant", etudiant);

        
        request.getRequestDispatcher("reponse.jsp").forward(request, response);
    }
}
