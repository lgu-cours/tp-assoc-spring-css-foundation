package iut.ac.controlejee.bean;

import java.util.LinkedList;

public class ListePays {

	public final static LinkedList getList ()
	{
		LinkedList list = new LinkedList();
		list.add(new Pays("FR","France") );
		list.add(new Pays("ES","Espagne") );
		list.add(new Pays("IT","Italie") );
		list.add(new Pays("BE","Belgique") );
		list.add(new Pays("CA","Canada") );
		
		
		return list ;
	}
}
