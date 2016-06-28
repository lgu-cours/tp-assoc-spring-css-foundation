<%@ include file="../jspf/Header.jspf" %>
<section>
	<h1>Catalogue des articles</h1>
	<p class="alert callout">${message}</p>
	<table>
	  <thead>
	    <tr>
	      <th width="200">Code</th>
	      <th>Nom</th>
	      <th width="150">Stock</th>
	      <th width="150">Prix</th>
	      <th></th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${articles}" var="article">
	    	<spring:url value="/articles/add/${article.code}" var="articleCommandeUrl" />
			<tr><td>${article.code}</td><td>${article.nom}</td><td>${article.stock}</td><td>${article.prix}</td><td><a href="${articleCommandeUrl}" class="button">Commander</a></td></tr>
		</c:forEach>
	  </tbody>
	</table>
</section>
<%@ include file="../jspf/Footer.jspf" %>