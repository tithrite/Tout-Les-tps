<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.appgesclients.Client" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Clients</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
       
        padding: 30px;
    }
    .container {
        

        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    .btn-add {
        background-color: #0d6efd;
        color: white;
    }
    
    .card-header {
        background-color: #0d6efd;
        color: white;
        font-size: 1.4rem;
        font-weight: 600;
        border-top-left-radius: 8px;
        border-top-right-radius: 8px;
        text-align: left;
        padding: 15px 25px;
    }

</style>

</head>
<body>

<div class="container">
    <table class="table table-bordered table-striped text-center align-middle">
        <thead class="">
         <div class="card-header">
            
                <div class="card-header">
        Liste des Clients
   
            
             </div>
            <tr>
                <th colspan="5">
                    <form class="d-flex justify-content-center" action="ListClientsServlet" method="get">
                        Client :       <input type="text" class="form-control w-50 me-5"  name="nom" required
                        >
                        
                        <button type="submit" class="btn btn-primary me-4" >Chercher</button>
                        <a href="addClient.jsp" class="btn btn-success me-6">Nouveau client</a>
                    </form>
                </th>
            </tr>
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
                 List<com.appgesclients.Client> clients = (List<com.appgesclients.Client>) request.getAttribute("clients");
                   if (clients != null && !clients.isEmpty()) {
                    for (com.appgesclients.Client c : clients) {
             %>
         <tr>
             <td><%= c.getId() %></td>
             <td><%= c.getNom() %></td>
             <td><%= c.getPrenom() %></td>
             <td><%= c.getAge() %></td>
             <td>
                      <a href="EditClientPageServlet?id=<%= c.getId() %>" class="btn btn-sm btn-warning">Modifier</a>

                      <a href="deleteClient?id=<%= c.getId() %>" class="btn btn-sm btn-danger">Supprimer</a>

             </td>
        </tr>
          <%
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

</body>
</html>
