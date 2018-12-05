package com;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.MongoClient; // the client
import com.mongodb.*; // top-level
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class Repository {
private static List <User> users = new ArrayList <User> ();
public static DB db;
public static DBCollection coll;

static BasicDBObject doc1 = new BasicDBObject(); // works like a HashMap ; using put (key,value);
public static boolean init() throws UnknownHostException
{
	try
	{
		MongoClient client = new MongoClient();
		System.out.println("Client läuft "+client);
	    db = client.getDB("user"); // if not exists => create
	    if(db == null)
	    	System.err.println("Datenbank konnte nicht erzeugt werden.");
	    else
	    	 System.out.println("Datenbank-Referenz wurde erzeugt.");
	    System.out.println("Datenbankname ["+db.toString()+"]");
	    
	    coll = db.createCollection("useritem",null); // where useritem = collectionname
	    
	}
	catch(Exception exeConnect)
	{
		System.out.println(exeConnect.toString());
	}
	return true;
}
static void fillRepository()
{
	// folgende
	System.out.println("folgende Elemente sind im Repository");
	users = Hauptapp.testArray();
	
}
static void saveRepository()
{
	for (User u : users)
	{
		doc1.append("username",u.getUsername())
		.append("password", u.getPassword())
		.append("personal-id", u.getFid());
		coll.insert(doc1);
		
	}
}
static void retrieveFromRepository(String u,String p)
{
	BasicDBObject whereQuery = new BasicDBObject();
	whereQuery.put("username", u);
	
	DBCursor cursor = coll.find(whereQuery); // get ALL 
	while(cursor.hasNext())
	{
		String treffer = "";
		treffer=cursor.next().toString();
		// check with regex if password is contained:
		String regex = p;
		Pattern p1 = Pattern.compile(regex);
		Matcher matcher = p1.matcher(treffer);
		if(matcher.find())
		{
			Object[] options = { "Ok" };
			JOptionPane.showOptionDialog(null, "Identifikation abgeschlossen! Hallo "+u, "Meldung",
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			null, options, options[0]);
			return;
		}
		else
		{
			
		}
	}
	Object[] options = { "OK", "CANCEL" };
	JOptionPane.showOptionDialog(null, "Nicht identifizierter Benutzer!", "Warnung",
	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	null, options, options[0]);
}
}
