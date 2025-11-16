<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Client" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Clients</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    font-family: 'Segoe UI', sans-serif;
    padding: 30px;
    background-color: #f8f9fa;
}
.container-card {
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    background-color: #fff;
}
.card-header {
    background-color: #0d6efd;
    color: white;
    font-size: 1.4rem;
    font-weight: 600;
    border-radius: 8px 8px 0 0;
    text-align: left;
    padding: 15px 25px;
}
.table th, .table td {
    vertical-align: middle;
    text-align: center;
}
.btn-primary { background-color: #0d6efd; border: none; }
.btn-primary:hover { background-color: #0b5ed7; }
</style>
</head>
<body>

<div class="container container-card">
    <div class="card-header mb-3">
        Liste des Clients
    </div>

    <form class="d-flex justify-content-center mb-3" action="ClientServlet" method="get">
        <input type="hidden" name="action" value="list">
        <input type="text" class="form-control w-50 me-3" name="nom" placeholder="Rechercher par nom" value="<%= request.getParameter("nom") != null ? request.getParameter("nom") : "" %>">
        <button type="submit" class="btn btn-primary me-2">Chercher</button>
        <a href="ClientServlet?action=new" class="btn btn-success">Nouveau client</a>
    </form>
    

    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Âge</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Client> clients = (List<Client>) request.getAttribute("listeClients");
            String search = request.getParameter("nom");
            if (clients != null && !clients.isEmpty()) {
                for (Client c : clients) {
                    if (search == null || c.getNom().toLowerCase().contains(search.toLowerCase())) {
        %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getNom() %></td>
                <td><%= c.getPrenom() %></td>
                <td><%= c.getAge() %></td>
                <td>
                    <a href="ClientServlet?action=edit&id=<%= c.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                    <a href="ClientServlet?action=delete&id=<%= c.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer ce client ?');">Supprimer</a>
                </td>
            </tr>
        <%
        
                    }
                }
                
                
            } else {
        %>
        
            <tr>
                <td colspan="5" class="text-center">Aucun client trouvé</td>
            </tr>
            
            
        <%
        
        
            }
            
            
        %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
