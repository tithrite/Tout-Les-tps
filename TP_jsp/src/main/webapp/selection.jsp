<html>
<head>
    <title>Choix de couleur</title>
</head>
<body>
    <h2>Choisissez une couleur</h2>

    <form method="post" action="selection.jsp">
        <select name="couleur">
            <option value="Rouge">Rouge</option>
            <option value="Bleu">Bleu</option>
            <option value="Vert">Vert</option>
        </select>
        <input type="submit" value="Envoyer" />
    </form>

    <%
        if(request.getMethod().equalsIgnoreCase("POST")) {
            String couleur = request.getParameter("couleur");
            out.println("<h3>Vous avez choisi la couleur " + couleur + "</h3>");
        }
    %>
</body>
</html>
