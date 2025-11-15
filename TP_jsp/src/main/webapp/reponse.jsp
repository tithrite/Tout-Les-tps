<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ilcs.Etudiant" %>
<html>
<head>
    <title>Réponse Étudiant</title>
</head>
<body>
    <h2>Détails de l'étudiant</h2>

    <%
        Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
        if(etudiant != null) {
    %>
        <p>Nom : <%= etudiant.getNom() %></p>
        <p>Prénom : <%= etudiant.getPrenom() %></p>
        <p>Note : <%= etudiant.getNote() %></p>
    <%
        } else {
            out.println("<p>Aucun étudiant trouvé.</p>");
        }
    %>
</body>
</html>
