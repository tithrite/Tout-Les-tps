package MonProjet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import  jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newUser")
public class TraitementFormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    String bgColor=request.getParameter("bgcol");
	    String police=request.getParameter("police");
	    String livre=request.getParameter("type");
	    int  nbr=Integer.parseInt(request.getParameter("nbr"));
	    
	    
	    Cookie c= new Cookie("bgcolor", bgColor);
	    c.setMaxAge(60*60*24*365);
	    response.addCookie(c );
	    
	    
	    
	    Cookie p= new Cookie("police", police);
	    p.setMaxAge(60*60*24*365);
	    response.addCookie(p);
	    
	    Cookie t= new Cookie("livre", livre);
	    t.setMaxAge(60*60*24*365);
	    response.addCookie(t);
	    
	    
	    
	    Cookie n= new Cookie("nbr","" +nbr);
	    n.setMaxAge(60*60*24*365);
	    response.addCookie(n);
	    
	    
	    
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>TP 3</title></head>");
        out.println("<body>");
        out.println("<center><h1 > Préférence Utilisateure bien enregistrées</h1></center>");
        out.println("<center><a href='accueill' > Accueil</a>");

        out.println("</body>");
        out.println("</html>");
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
