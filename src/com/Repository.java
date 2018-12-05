package com;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.MongoClient; // the client
import com.mongodb.*; // top-level


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
	System.out.println("folgende ELemente sind im Repository");
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
}
