<%@ include file="../jspf/Header.jspf" %>

<section>
	<p class="alert callout">${message}</p>
	<c:choose >
		<c:when test="${isAuth}">
			<h1>Bienvenue sur le site des adherents de l'association</h1>
			<ul>
				<li><a href="${articlesUrl}">Consulter les articles disponibles</a></li>
				<li><a href="${commandeUrl}">Consulter votre commande</a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<h1>Accueil</h1>
			<p>Welcome</p>
		</c:otherwise>
	</c:choose>
	
</section>
<%@ include file="../jspf/Footer.jspf" %>