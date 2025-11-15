<html>
<head>
    <title>Choix de couleur</title>
</head>
<body>
    <h2>Choisissez une couleur</h2>

    <form method="post" action="selection2.jsp">
        <select name="couleur">
            <option value="Rouge">Rouge</option>
            <option value="Bleu">Bleu</option>
            <option value="Vert">Vert</option>
            <option value="Orange">Orange</option>
        </select>
        <input type="submit" value="Envoyer" />
    </form>

    <%
        if(request.getMethod().equalsIgnoreCase("POST")) {
            String couleur = request.getParameter("couleur");
            if("Orange".equalsIgnoreCase(couleur)) {
                throw new Exception("Cette couleur n'est pas belle");
            } else {
                out.println("<h3>Vous avez choisi la couleur " + couleur + "</h3>");
            }
        }
    %>
</body>
</html>
