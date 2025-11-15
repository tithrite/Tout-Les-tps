<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="etudiant" class="beans.Etudiant" scope="request" />

<!DOCTYPE html>
<html>
<head>
    <title>Résultat</title>
</head>
<body>
    <h1>Informations de l'étudiant avec note</h1>
    <p>Nom : <jsp:getProperty name="etudiant" property="nom" /></p>
    <p>Prénom : <jsp:getProperty name="etudiant" property="prenom" /></p>
    <p>Note : <jsp:getProperty name="etudiant" property="note" /></p>
    
</body>
</html>