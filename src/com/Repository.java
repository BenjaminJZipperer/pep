package com;

import java.util.ArrayList;
import java.util.List;

public class Repository {
private static List <User> users = new ArrayList <User> ();


static void fillRepository()
{
	// folgende
	System.out.println("folgende ELmente sind im Repository");
	users = Hauptapp.testArray();
}
static void saveRepository()
{
	
}
}
