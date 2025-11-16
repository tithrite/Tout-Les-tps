package com.example.controller;

import com.example.model.Client;
import com.example.model.ClientDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    private ClientDao dao;

    @Override
    public void init() {
        dao = new ClientDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new" -> showForm(request, response);
                case "insert" -> insertClient(request, response);
                case "delete" -> deleteClient(request, response);
                case "edit" -> showEditForm(request, response);
                case "update" -> updateClient(request, response);
                default -> listClients(request, response); 
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur base de données : " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   
    private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        String nomRecherche = request.getParameter("nom"); 
        List<Client> liste;

        if (nomRecherche != null && !nomRecherche.trim().isEmpty()) {
            liste = dao.rechercherParNom(nomRecherche); 
        } else {
            liste = dao.lister(); 
        }

        request.setAttribute("listeClients", liste);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));
        Client c = new Client(nom, prenom, age);
        dao.ajouter(c);
        response.sendRedirect("ClientServlet?action=list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.supprimer(id);
        response.sendRedirect("ClientServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = dao.chercher(id);
        request.setAttribute("client", client);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));

        Client c = new Client(id, nom, prenom, age);
        dao.modifier(c);
        response.sendRedirect("ClientServlet?action=list");
    }
}
