package com.estn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/simple")

public class SimpleServlet implements Servlet {

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		}

	@Override
	public void service(ServletRequest request, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html;charset=UTF-8");
		PrintWriter out = arg1.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ma première servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 align='center'>simple servlet </h2>");
        out.println("<h2 align='center'>" + new Date() + "</h2>");
        out.println("<table align='center' border=1>" );
        
        out.println("<tr>");
        out.println("<td colspan=2>Liste des parametres</td>");
        out.println("</tr>");
        
        for ( Enumeration<String> paramsListe =  request.getServletContext().getInitParameterNames();paramsListe.hasMoreElements();){
      	  String param = paramsListe.nextElement();
      	  out.println("<tr>");
            out.println("<td>"+param+"</td>");
            out.println("<td>"+ request.getServletContext().getInitParameter(param)+"</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
		
	}

}
