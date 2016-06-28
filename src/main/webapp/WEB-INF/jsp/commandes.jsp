<%@ include file="../jspf/Header.jspf" %>
<section>
	<h1>Votre commande</h1>
	<p class="alert callout">${message}</p>
	<c:if test="${hasCommand}">
	<table>
	  <thead>
	    <tr>
	      <th width="200">Code</th>
	      <th>Nom</th>
	      <th width="150">Prix</th>
	      <th></th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${articles}" var="article">
	    	<spring:url value="/articles/add/${article.code}" var="articleCommandeUrl" />
			<tr><td>${article.code}</td><td>${article.nom}</td><td>${article.prix}</td></tr>
		</c:forEach>
	  </tbody>
	</table>
	
	<spring:url value="/commandes/destroy" var="destroyUrl" />
	<a href="${destroyUrl}">Annuler la commande</a>
	</c:if>
</section>
<%@ include file="../jspf/Footer.jspf" %>