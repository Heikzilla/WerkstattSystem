package controller;

import general.Kfz;

import java.util.ArrayList;

import database.DB;

public class c_kfz {

	private static c_kfz INSTANCE;


    public static c_kfz getInstance(){

        if(INSTANCE == null){

            INSTANCE = new c_kfz();

        }

        return INSTANCE;

    }


    public ArrayList<Kfz> getKfzList(){

        //FOR TESTING REMOVED
        //return new ArrayList<Auftrag>();

        //return DB.getInstance().kundeSelect("SELECT * FROM kunde");

    	return null;
    }
    
    public void addKfzToDB(Kfz neuesKfz){
    	
    	String sql = "INSERT INTO kfz "
				+ "(marke, modell, kennzeichen, kunde_ID) VALUES "
				+ " (" + "'" + neuesKfz.getMarke()+ "'" + 
				", " + "'" + neuesKfz.getModell() + "'" + 
				", " + "'" + neuesKfz.getKennzeichen() + "'" + 
				", " + neuesKfz.getKunde_ID() +
				");";
    	DB.getInstance().tableInsert(sql);
    }
    
	
}
