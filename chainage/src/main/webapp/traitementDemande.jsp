<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="etudiant" class="beans.Etudiant" scope="request" />
<jsp:setProperty name="etudiant" property="nom" />
<jsp:setProperty name="etudiant" property="prenom" />


<jsp:forward page="/TraitementServlet" />