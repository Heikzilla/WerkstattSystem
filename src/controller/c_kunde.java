package controller;

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
	
}
