package com;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Hauptapp {
public static User[] benutzer = new User[9];
public static void main(String[] ard) throws UnknownHostException
{
	System.out.println("Starte Testprozedur - Anlegen von 2 Testusern: ");
	User users[] = new User[3];
	users[1] = new User("Benjamin","stackholder");
	System.out.println(users[1].toString());
	users[2] = new User("admin","password");
	System.out.println(users[2].toString());
	// 15 Minuten
	
	// Tag 2
	Repository.init();
	
	// STarte die AWT Event Schlange 
	java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new LogFenster().setVisible(true);
        }
    });
	initArray();
	
}
public static void initArray()
{
	for(int i = 0 ; i < benutzer.length ; i++)
	{
		benutzer[i] = null;
	}
}
public static List<User> testArray()
{
	List<User> rueckgabe = null;
	rueckgabe = new ArrayList<User>();
	
	for(int i = 0 ; i < benutzer.length ; i++)
	{
		if(benutzer[i]!=null) {
		System.out.println("Test: "+benutzer[i].toString());
		
		rueckgabe.add(benutzer[i]);
		}
	}
	return rueckgabe;
}
}
