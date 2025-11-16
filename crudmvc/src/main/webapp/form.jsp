<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Client" %>

<%
    Client client = (Client) request.getAttribute("client");
    boolean editMode = (client != null);
    String actionUrl = editMode ? "ClientServlet?action=update" : "ClientServlet?action=insert";
    String buttonText = editMode ? "Modifier" : "Ajouter";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= editMode ? "Modifier Client" : "Ajouter Client" %></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>


body { font-family: 'Segoe UI', sans-serif; background-color: #f8f9fa; }

.container-card { margin: 60px auto; max-width: 600px; }
.card { border: 1px solid #bcd0f7; box-shadow: 0 3px 10px rgba(0,0,0,0.1); border-radius: 8px; }
.card-header { background-color: #0d6efd; color: white; font-size: 1.4rem; font-weight: 600; border-radius: 8px 8px 0 0; padding: 15px 25px; }
.card-body { background-color: #fff; padding: 30px; }
.btn-primary { background-color: #0d6efd; border: none; }
.btn-primary:hover { background-color: #0b5ed7; }


</style>
</head>
<body>

<div class="container-card">
    <div class="card">
        <div class="card-header">
            <%= editMode ? "Modifier Client" : "Ajouter Client" %>
        </div>
        <div class="card-body">
            <form action="<%= actionUrl %>" method="post">
                <% if(editMode) { %>
                    <input type="hidden" name="id" value="<%= client.getId() %>">
                <% } %>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Nom :</label>
                    <input type="text" class="form-control" name="nom" value="<%= editMode ? client.getNom() : "" %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Prénom :</label>
                    <input type="text" class="form-control" name="prenom" value="<%= editMode ? client.getPrenom() : "" %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-semibold">Âge :</label>
                    <input type="number" class="form-control" name="age" value="<%= editMode ? client.getAge() : "" %>" required>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-primary"><%= buttonText %></button>
                    <a href="ClientServlet?action=list" class="btn btn-secondary ms-2">Annuler</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
