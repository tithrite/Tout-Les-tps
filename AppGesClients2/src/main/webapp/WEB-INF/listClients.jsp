<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.appgesclients2.model.Client" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Clients</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 40px;
            background-color: #f8f9fa;
        }
        .container {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
            padding: 25px;
        }
        .header-custom {
            background-color: #0d6efd;
            color: white;
            padding: 15px 25px;
            border-radius: 10px 10px 0 0;
            font-weight: bold;
            font-size: 1.3rem;
        }
        .btn-search {
            background-color: #0d6efd;
            color: white;
        }
        .btn-add {
            background-color: #198754;
            color: white;
        }
        .table th {
            background-color: #f8f9fa;
        }
        input[type="text"] {
            width: 250px;
            display: inline-block;
        }
    </style>
    
    
</head>
<body>

<div class="container">
   
    <div class="header-custom mb-3">Liste des Clients</div>

    
    <form action="ClientController" method="get" class="d-flex mb-3 justify-content-between align-items-center">
        <div>
              <input type="hidden" name="action" value="search">
            <input type="text" name="keyword" class="form-control d-inline-block" placeholder="Rechercher par nom">
        </div>
        
        
        <div>
        
            <button type="submit" class="btn btn-search me-2">Chercher</button>
             <a href="ClientController?action=add" class="btn btn-add">Nouveau client</a>
        </div>
    </form>

    <%
    
    
        List<Client> clients = (List<Client>) request.getAttribute("clients");
    
        if (clients == null || clients.isEmpty()) {
    %>
    
    
          <p class="text-center text-muted">Aucun client trouvé.</p>
    <%
         } else {
    %>
        <table class="table table-bordered text-center align-middle">
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
                    
                for (Client c : clients) {
                %>
                <tr>
                
                
                    <td><%= c.getId() %></td>
                    <td><%= c.getNom() %></td>
                    <td><%= c.getPrenom() %></td>
                     <td><%= c.getAge() %></td>
                    <td>
                    
                    
                     <a href="ClientController?action=edit&id=<%= c.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                        <a href="ClientController?action=delete&id=<%= c.getId() %>" 
                           onclick="return confirm('Voulez-vous vraiment supprimer ce client ?');"
                           class="btn btn-sm btn-danger">Supprimer</a>
                    </td>
                
                </tr>
                <%
                
                    }
                %>
            </tbody>
        </table>
    <%
        
         }
    %>
</div>


</body>
</html>
