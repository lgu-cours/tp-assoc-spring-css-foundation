package iut.ac.controlejee.bean;

import java.util.Iterator;
import java.util.LinkedList;

public class ListeArticles {
	
	public final static LinkedList getList ()
	{
		LinkedList list = new LinkedList();
		list.add(new Article("T1","Tee Shirt", 12, 55.60) );
		list.add(new Article("C2","Cle USB", 45, 9.50 ) );
		list.add(new Article("S3","Stylo", 34, 3.70 ) );
		list.add(new Article("C4","Calculatrice", 4, 20.00 ) );
		
		
		return list ;
	}
	
	public final static Article chercherArticle ( LinkedList list,  String sId )
	{
		if ( list == null )
		{
			System.out.println("ERREUR : chercherArticle: le parametre 'list' est NULL ");
			return null ;
		}
		if ( sId == null )
		{
			System.out.println("ERREUR : chercherArticle: le parametre 'id' est NULL ");
			return null ;
		}
		Iterator it = list.iterator() ;
		while ( it.hasNext())
		{
			Article a = (Article) it.next();
			if ( a != null )
			{
				if ( a.getCode().equalsIgnoreCase(sId) )
				{
					return a ;
				}
			}
		}
		return null ;
	}
}
