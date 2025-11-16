<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'Segoe UI', sans-serif;
        background-color: #f8f9fa;
        padding: 40px;
    }
    .card {
        margin: 50px auto;
        max-width: 600px;
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
    .btn-space {
        margin-left: 10px;
    }
</style>
</head>
<body>
<div class="card">
    <div class="card-header">Nouveau Client</div>
    <div class="card-body">
        <form action="ClientController?action=add" method="post">
            <div class="mb-3">
                <label class="form-label fw-semibold">Nom :</label>
                <input type="text" class="form-control" name="nom" required />
            </div>
            <div class="mb-3">
                <label class="form-label fw-semibold">Prénom :</label>
                <input type="text" class="form-control" name="prenom" required />
            </div>
            <div class="mb-3">
                <label class="form-label fw-semibold">Âge :</label>
                <input type="number" class="form-control" name="age" required />
            </div>
            <div class="text-end">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="ClientController?action=list" class="btn btn-secondary btn-space">Annuler</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
