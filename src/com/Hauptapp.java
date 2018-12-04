package com;

import java.util.ArrayList;
import java.util.List;

public class Hauptapp {
public static User[] benutzer = new User[9];
public static void main(String[] ard)
{
	User users[] = new User[3];
	users[1] = new User("Benjamin","garfield");
	System.out.println(users[1].toString());
	users[2] = new User("admin","password");
	System.out.println(users[2].toString());
	// 15 Minuten
	
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
