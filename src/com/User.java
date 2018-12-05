package com;

public class User {
private static int id = 905;
private boolean admin = false;
private int 	fid;
private String  username;
private String  password;
public User(String username, String password) 
{
	super();
	fid = id;
	id++;
	this.username = username;
	if(username == "admin")
		admin = true;
	this.password = password;
}
public int getFid() 
{
	return fid;
}
public String getUsername() 
{
	return username;
}
public String getPassword() 
{
	return password;
}
public void setFid(int fid) 
{
	this.fid = fid;
}
public void setUsername(String username) 
{
	this.username = username;
}
public void setPassword(String password) 
{
	this.password = password;
}
@Override
public String toString() 
{
	return "User-Informationen: \n[admin=" + admin + ", fid=" + fid + ", username=" + username + ", password=" + password + "]";
}

}
