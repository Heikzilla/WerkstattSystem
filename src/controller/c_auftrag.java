package controller;

import general.Auftrag;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.DB;

public class c_auftrag {

    private static c_auftrag INSTANCE;


    public static c_auftrag getInstance(){

        if(INSTANCE == null){

            INSTANCE = new c_auftrag();

        }

        return INSTANCE;

    }


    public ArrayList<Auftrag> getAuftragList(){

        //FOR TESTING REMOVED
        //return new ArrayList<Auftrag>();

        return randomAuftragList();

    }


    //TESTING
    private ArrayList<Auftrag> randomAuftragList(){

        ArrayList<Auftrag> ret = new ArrayList<>();
        ret.add(new Auftrag(0,"TEST 1", false, 0));
        ret.add(new Auftrag(1,"TEST 2", false, 1));
        ret.add(new Auftrag(2,"TEST 3", true, 1));
        ret.add(new Auftrag(3,"TEST 4", false, 2));
        ret.add(new Auftrag(4,"TEST 5", true, 3));
        ret.add(new Auftrag(5,"TEST 6", false, 4));

        return ret;

    }
    
    
    public DefaultTableModel getAuftragListAsTable(){
    	
    	String sql = "SELECT kfz.marke AS Marke"
	 +", kfz.modell AS Modell"
	 +", kfz.kennzeichen AS 'Kennz.'"
	 +", auftraege.arbeiten AS Bemerkung"
	 +", CONCAT(kunde.vorname,' ', kunde.nachname) AS 'K. Name'"
	 +", kunde.kunde_ID AS 'K. ID'"
	 +", CASE WHEN auftraege.erledigt = true THEN 'Erledigt' ELSE 'Offen' END AS 'Status'"
	 +" FROM auftraege"
	 +" INNER JOIN kfz ON auftraege.kfz_ID = kfz.kfz_ID"
	 +" INNER JOIN kunde ON kunde.kunde_ID = kfz.kunde_ID";
    	
    	System.out.println(sql);
    	
    	return DB.getInstance().tableSelect(sql);
    	
    }

}
