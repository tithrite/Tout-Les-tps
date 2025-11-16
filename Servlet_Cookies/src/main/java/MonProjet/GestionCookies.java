package MonProjet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/accueill")
public class GestionCookies extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bgcolor = null;
        String police = null;
        String type = null;
        int nbr = 0;

        
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {

                if (cookies[i].getName().equals("bgcolor")) {
                    bgcolor = cookies[i].getValue();
                }

                if (cookies[i].getName().equals("police")) {
                    police = cookies[i].getValue();
                }

                if (cookies[i].getName().equals("livre")) {
                    type = cookies[i].getValue();
                }

                if (cookies[i].getName().equals("nbr")) {
                    try {
                        nbr = Integer.parseInt(cookies[i].getValue());
                    } catch (NumberFormatException e) {
                        nbr = 0; 
                    }
                }
            }
        }

        if (bgcolor == null && police == null && type == null) {
            response.sendRedirect(request.getContextPath() + "/index.html");
        } else {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head><title>Accueil</title></head>");
            out.println("<body bgcolor='" + (bgcolor != null ? bgcolor : "white") + "'>");
            out.println("<font color='" + (police != null ? police : "black") + "'>");
            out.println("<h1>Bienvenue</h1>");
            out.println("<center>Votre nbr préféré est : " + nbr + "</center>");

            if ("Programmation".equalsIgnoreCase(type)) {
                out.println("<p>Programmer en Java, Claude Delannoy</p>");
                out.println("<p>Spring in Action, Rod Johnson</p>");

            } else if ("Sécurité".equalsIgnoreCase(type)) {
                out.println("<p>Sécurité en Java, Claude Delannoy</p>");
                out.println("<p>Cyber, Rod Johnson</p>");

            } else if ("Ingénierie".equalsIgnoreCase(type)) {
                out.println("<p>MDA, Claude Delannoy</p>");
                out.println("<p>UML, Rod Johnson</p>");
            }

            out.println("</font>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    

}