package br.com.pi.drot.controllers;

import java.util.Observable;

public class EssentialsFXController extends Observable{
	protected static String loggedUserName;
	
    public String getLoggedUserName() {
        return loggedUserName;
    }
    public void setLoggedUserName(String name) {
        loggedUserName = name;
        setChanged();
		notifyObservers();
    }
}
