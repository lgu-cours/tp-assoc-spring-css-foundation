package iut.ac.controlejee.bean;

import java.util.LinkedList;

public class Commande {

	LinkedList listCommande = new LinkedList();
	
	//LinkedList listCatalogue = null ;
	
	
//	public Commande(LinkedList listCatalogue) {
//		super();
//		//this.listCatalogue = listCatalogue;
//	}

	public void commanderArticle(Article a )
	{
		listCommande.add(a);
		System.out.println("Article command� : " + a.getCode() + " : " + a.getNom() );
	}

	public int getNbArticles()
	{
		return listCommande.size();
	}
	
	public LinkedList getListe()
	{
		return listCommande ;
	}
}
