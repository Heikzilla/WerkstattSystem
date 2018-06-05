package controller;

import general.Kunde;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.DB;

public class c_kunde {

	private static c_kunde INSTANCE;


    public static c_kunde getInstance(){

        if(INSTANCE == null){

            INSTANCE = new c_kunde();

        }

        return INSTANCE;

    }


    public ArrayList<Kunde> getKundeList(String filter){

    	String sql = "SELECT * FROM kunde "+filter;    	
    	DefaultTableModel tbl = DB.getInstance().tableSelect(sql);
    	
    	ArrayList<Kunde> returnList = new ArrayList<>();
    	
    	for(int rowID = 0; rowID < tbl.getRowCount(); rowID ++){
			returnList.add(new Kunde(
					 (Integer)tbl.getValueAt(rowID,0) //Kunde_ID
					,(String)tbl.getValueAt(rowID,1)  //vorname
					,(String)tbl.getValueAt(rowID,2)  //nachname
					,(Integer)tbl.getValueAt(rowID,3) //plz
					,(String)tbl.getValueAt(rowID,4)  //ort
					,(String)tbl.getValueAt(rowID,5)  //strasse
					,(String)tbl.getValueAt(rowID,6)) //hausnummer
			);
    	}

        return returnList;

    }
    
    public void addKundeToDB(Kunde neuerKunde){
    	
    	String sql = "INSERT INTO kunde "
				+ "(vorname, nachname, ort, plz, strasse, hausnummer) VALUES "
				+ " (" + "'" + neuerKunde.getVorname()    + "'"  
				+ ", " + "'" + neuerKunde.getNachname()   + "'"  
				+ ", " + "'" + neuerKunde.getOrt() 		  + "'"  
				+ ", " 	     + neuerKunde.getPlz() 
				+ ", " + "'" + neuerKunde.getStrasse() 	  + "'"  
				+ ", " + "'" + neuerKunde.getHausnummer() + "'" 
				+ ");";
		
		
		DB.getInstance().tableInsert(sql);
    }
	
}
