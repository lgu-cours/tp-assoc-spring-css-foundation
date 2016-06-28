<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../jspf/Header.jspf" %>

<spring:url value="/user/login" var="formUrl"/>
<spring:url value="/user/compte" var="creerCompteUrl"/>
<section>
	<h1>Login</h1>
<%-- 	<form:form method="POST" action="/user/login" modelAttribute="adherent"> --%>
<%-- 		<form:label path="ident">Identifiant</form:label> --%>
<%-- 		<form:input path="ident"/> --%>
<%-- 		<form:label path="motpasse">Mot de passe</form:label> --%>
<%-- 		<form:input path="motpasse" />	 --%>
		
<!-- 		<input type="submit" value="Se connecter" /> -->
<%-- 	</form:form> --%>
	<p class="alert callout">${message}</p>
	<form method="POST" action="${formUrl}">
		<label for="ident">Identifiant :</label>
		<input type="text" name="ident" id="ident" />
		<label for="pass">Mot de passe :</label>
		<input type="password" name="pass" id="pass" />
		<input type="submit" value="Se connecter" class="button""/> 
	</form>
	<a href="${creerCompteUrl}">Creer un compte</a>
</section>
<%@ include file="../jspf/Footer.jspf" %>