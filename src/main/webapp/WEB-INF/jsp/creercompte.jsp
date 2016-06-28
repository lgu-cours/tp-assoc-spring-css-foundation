<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../jspf/Header.jspf" %>

<spring:url value="/user/compte" var="formUrl"/>
<p class="alert callout">${message}</p>
<section>
	<h1>Creer un compte</h1>
	<form method="POST" action="${formUrl}">
		<label for="ident">Identifiant* :</label>
		<input type="text" name="ident" id="ident" required/>
		<label for="pass">Mot de passe* :</label>
		<input type="password" name="motpasse" id="pass" required/>
		<label for="pass">Mot de passe (confirm)*:</label>
		<input type="password" name="motpasseconfirm" id="pass" required/>
		<label for="nom">Nom* :</label>
		<input type="text" name="nom" id="nom" required/>
		<label for="prenom">Prenom* :</label>
		<input type="text" name="prenom" id="prenom" required/>
		<label for="adresse">Adresse:</label>
		<input type="text" name="adresse" id="adresse" />
		<label for="codepost">Code postal:</label>
		<input type="text" pattern="\d{5}"name="codepost" id="codepost" />
		<label for="ville">Ville:</label>
		<input type="text" name="ville" id="ville" />
		<select name="codepays">
			<c:forEach items="${listePays}" var="pays">
				<option value="${pays.code}">${pays.nom}</option>
			</c:forEach>
		</select>
		<input type="submit" value="S'inscrire" class="button"/> 
	</form>
	* : Champs obligatoire
</section>
<%@ include file="../jspf/Footer.jspf" %>