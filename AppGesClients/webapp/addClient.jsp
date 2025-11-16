<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
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
    .btn-primary {
        background-color: #0d6efd;
        border: none;
    }
    .btn-primary:hover {
        background-color: #0b5ed7;
    }
</style>
</head>
<body>
<div class="card">
    <div class="card-header">
        Nouveau Client
    </div>
    <div class="card-body">
        <form action="AddClientServlet" method="post">

            <div class="mb-3">
                <label class="form-label fw-semibold">ID Client :</label>
                <input type="number" class="form-control" name="id" >
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Nom Client :</label>
                <input type="text" class="form-control" name="nom" >
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Prénom Client :</label>
                <input type="text" class="form-control" name="prenom" >
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Âge Client :</label>
                <input type="number" class="form-control" name="age" >
            </div>

            <div class="text-end">
               <a href="listClients.jsp" > <button type="submit" class="btn btn-primary">Ajouter</button></a>
            </div>
        </form>
    </div>
</div>

</body>
</html>