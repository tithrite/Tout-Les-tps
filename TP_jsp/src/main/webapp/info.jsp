<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ma première JSP</title>
</head>
<body>
    <h2 align="center"> Infos du client </h2>

    <table align="center">
        <tr>
            <td>Type mime de la requête</td>
            <td><%= request.getContentType() %></td>
        </tr>

        <tr>
            <td>Protocole de la requête</td>
            <td><%= request.getProtocol() %></td>
        </tr>

        <tr>
            <td>Adresse IP du client</td>
            <td><%= request.getRemoteAddr() %></td>
        </tr>

        <tr>
            <td>Nom du client</td>
            <td><%= request.getRemoteHost() %></td>
        </tr>

        <tr>
            <td>Nom du serveur qui a reçu la requête</td>
            <td><%= request.getServerName() %></td>
        </tr>

        <tr>
            <td>Port du serveur qui a reçu la requête</td>
            <td><%= request.getServerPort() %></td>
        </tr>

        <tr>
            <td>Scheme</td>
            <td><%= request.getScheme() %></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><b>Liste des paramètres</b></td>
        </tr>

        <%
            java.util.Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                String valeur = request.getParameter(param);
        %>
            <tr>
                <td><%= param %></td>
                <td><%= valeur %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
