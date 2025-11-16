package com.appgesclients2.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.appgesclients2.model.Client;
import com.appgesclients2.metier.IClientMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/ClientController")


public class ClientController extends HttpServlet {
	

    private IClientMetier clientMetier;

    @Override
    public void init() throws ServletException {
        super.init();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        clientMetier = (IClientMetier) context.getBean("clientMetier");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("/WEB-INF/addClient.jsp").forward(request, response);
                break;

            case "edit":
                Long idEdit = Long.parseLong(request.getParameter("id"));
                Client clientEdit = clientMetier.getClient(idEdit);
                request.setAttribute("client", clientEdit);
                request.getRequestDispatcher("/WEB-INF/editClient.jsp").forward(request, response);
                break;

            case "delete":
                Long idDelete = Long.parseLong(request.getParameter("id"));
                clientMetier.removeClient(idDelete);
                response.sendRedirect("ClientController?action=list");
                break;

            case "search":   
            	
                String keyword = request.getParameter("keyword");
                List<Client> searchResults;

                if (keyword != null && !keyword.trim().isEmpty()) {
                    searchResults = clientMetier.searchClientsByName(keyword);
                } else {
                    searchResults = clientMetier.getAllClients();
                }

                request.setAttribute("clients", searchResults);
                request.getRequestDispatcher("/WEB-INF/listClients.jsp").forward(request, response);
                break;

            case "list":
            default:
                List<Client> clients = clientMetier.getAllClients();
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("/WEB-INF/listClients.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        String action = request.getParameter("action");

        if ("add".equals(action)) {

            System.out.println("Form submitted with: nom=" + request.getParameter("nom")
                    + ", prenom=" + request.getParameter("prenom")
                    + ", age=" + request.getParameter("age"));

            Client client = new Client();

            client.setNom(request.getParameter("nom"));
            client.setPrenom(request.getParameter("prenom"));
            client.setAge(Integer.parseInt(request.getParameter("age")));

            clientMetier.addClient(client);
            response.sendRedirect("ClientController?action=list");
            
            

        } else if ("edit".equals(action)) {
        	
        	

            Long id = Long.parseLong(request.getParameter("id"));
            Client client = clientMetier.getClient(id);

            client.setNom(request.getParameter("nom"));
            client.setPrenom(request.getParameter("prenom"));
            client.setAge(Integer.parseInt(request.getParameter("age")));

            clientMetier.updateClient(client);
            response.sendRedirect("ClientController?action=list");
        }
    }
}
