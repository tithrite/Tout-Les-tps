<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="com.appgesclients.Client" %>



<%
    Client client = (Client) request.getAttribute("client");
    if (client == null) {
        response.sendRedirect("ListClientsServlet");
        return;
    }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mettre  à jour les information du client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style >


body {
   
    font-family: 'Segoe UI', sans-serif;
}
.card {
    margin: 60px auto;
    max-width: 600px;
    border: 1px solid #bcd0f7;
    box-shadow: 0 3px 10px rgba(0,0,0,0.1);
    border-radius: 8px;
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

.card-body {
    background-color: #fff;
    padding: 30px;
}

</style>

</head>
<body>
<div  class="card">
<div  class="card-header">
    Mettre  à jour les information du client
</div>
    <div class="card-body ">
     <form action="EditClientServlet" method="post">
    <input type="hidden" name="id" value="<%= client.getId() %>">
    <div class="mb-3">
        <label class="form-label fw-semibold">Nom :</label>
        <input class="form-control" type="text" name="nom" value="<%= client.getNom() %>" required>
    </div>
    <div class="mb-3">
        <label class="form-label fw-semibold">Prénom :</label>
        <input class="form-control" type="text" name="prenom" value="<%= client.getPrenom() %>" required>
    </div>
    <div class="mb-3">
        <label class="form-label fw-semibold">Âge :</label>
        <input class="form-control" type="number" name="age" value="<%= client.getAge() %>" required>
    </div>
    <button class="btn btn-primary" type="submit">Modifier</button>
    <a href="ListClientsServlet" class="btn btn-secondary ms-2">Annuler</a>
</form>

</div>

 </div>
</body>
</html>