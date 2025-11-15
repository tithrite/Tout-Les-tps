package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Hello")
public class MaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ma première servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 align='center'>Bonjour le monde</h2>");
        out.println("<h2 align='center'>" + new Date() + "</h2>");
        out.println("</body>");
        out.println("</html>");
        
        }
    }

