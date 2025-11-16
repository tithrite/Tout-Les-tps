<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculer Prime</title>
</head>
<body>
    <h2>Calculer la Prime d'un Employé</h2>
    
    <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;">${error}</p>
    <% } %>
    
    <form action="calculerPrime" method="post">
    <label>ID Employé:</label>
    <input type="number" name="id" required/>
    <br/><br/>
    <input type="submit" value="Calculer Prime"/>
</form>
</body>
</html>
