<html>
<head>
    <title>Calculette JSP</title>
</head>
<body>
    <h2>Calculette JSP</h2>

    <form method="get" action="calculette.jsp">
        Opérande 1: <input type="text" name="op1" value="<%= request.getParameter("op1") != null ? request.getParameter("op1") : "" %>" /><br/><br/>
        Opérande 2: <input type="text" name="op2" value="<%= request.getParameter("op2") != null ? request.getParameter("op2") : "" %>" /><br/><br/>

        Opération :
        <select name="operation">
            <option value="addition" <%= "addition".equals(request.getParameter("operation")) ? "selected" : "" %>>Addition</option>
            <option value="soustraction" <%= "soustraction".equals(request.getParameter("operation")) ? "selected" : "" %>>Soustraction</option>
            <option value="multiplication" <%= "multiplication".equals(request.getParameter("operation")) ? "selected" : "" %>>Multiplication</option>
            <option value="division" <%= "division".equals(request.getParameter("operation")) ? "selected" : "" %>>Division</option>
        </select>
        <br/><br/>
        <input type="submit" value="Calculer" />
    </form>

    <%
        String op1Str = request.getParameter("op1");
        String op2Str = request.getParameter("op2");
        String operation = request.getParameter("operation");

        if(op1Str != null && op2Str != null && operation != null) {
            try {
                double op1 = Double.parseDouble(op1Str);
                double op2 = Double.parseDouble(op2Str);
                double resultat = 0;
                boolean ok = true;

                switch(operation) {
                    case "addition": resultat = op1 + op2; break;
                    case "soustraction": resultat = op1 - op2; break;
                    case "multiplication": resultat = op1 * op2; break;
                    case "division": 
                        if(op2 != 0) resultat = op1 / op2;
                        else {
                            out.println("<p style='color:red'>Division par zéro impossible !</p>");
                            ok = false;
                        }
                        break;
                }

                if(ok) {
                    out.println("<h3>Résultat : " + resultat + "</h3>");
                }
            } catch(NumberFormatException e) {
                out.println("<p style='color:red'>Erreur : saisie invalide.</p>");
            }
        }
    %>
</body>
</html>
