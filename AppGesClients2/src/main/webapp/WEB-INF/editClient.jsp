<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    
    <style>
    
         body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f8f9fa;
            padding: 40px;
        }
        .card {
            max-width: 600px;
            margin: 50px auto;
            border: 1px solid #bcd0f7;
            border-radius: 8px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
        }
        .card-header {
            background-color: #0d6efd;
            color: white;
            font-size: 1.4rem;
            font-weight: 600;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            padding: 15px 25px;
        }
        .card-body {
            padding: 30px;
            background-color: #fff;
        }
        .btn-space {
            margin-left: 10px;
        }
    </style>
    
</head>
<body>
<div class="card">

    <div class="card-header">Modifier Client</div>
    <div class="card-body">
       <form action="ClientController?action=edit" method="post">
             <input type="hidden" name="id" value="${client.id}" />
             
            <div class="mb-3">
            
                <label class="form-label fw-semibold">Nom :</label>
                <input class="form-control" type="text" name="nom" value="${client.nom}" required />
            </div>
            
            <div class="mb-3">
            
                <label class="form-label fw-semibold">Prénom :</label>
                <input class="form-control" type="text" name="prenom" value="${client.prenom}" required />
            </div>
            
            <div class="mb-3">
                <label class="form-label fw-semibold">Âge :</label>
                <input class="form-control" type="number" name="age" value="${client.age}" required />
            </div>
            
            
            <button class="btn btn-primary" type="submit">Modifier</button>
            <a href="ClientController?action=list" class="btn btn-secondary btn-space">Annuler</a>
        </form>
        
        
        
        
    </div>
</div>


</body>


</html>
