package controller;

import general.Kfz;
import general.Kunde;

import java.util.ArrayList;

import database.DB;

public class c_kunde {

	private static c_kunde INSTANCE;


    public static c_kunde getInstance(){

        if(INSTANCE == null){

            INSTANCE = new c_kunde();

        }

        return INSTANCE;

    }


    public ArrayList<Kunde> getKundeList(){

        //FOR TESTING REMOVED
        //return new ArrayList<Auftrag>();

        return DB.getInstance().kundeSelect("SELECT * FROM kunde");

    }
    
    public void addKundeToDB(Kunde neuerKunde){
    	
    	String sql = "INSERT INTO kunde "
				+ "(vorname, nachname, ort, plz, strasse, hausnummer) VALUES "
				+ " (" + "'" + neuerKunde.getVorname()+ "'" + 
				", " + "'" + neuerKunde.getNachname() + "'" + 
				", " + "'" + neuerKunde.getOrt() + "'" + 
				", " + neuerKunde.getPlz() + 
				", " + "'" + neuerKunde.getStrasse() + "'" + 
				", " + "'" + neuerKunde.getHausnummer() + "'" +
				");";
		
		
		DB.getInstance().tableInsert(sql);
    }
	
}
