package controller;

import general.Auftrag;
import general.Kfz;

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


    public ArrayList<Auftrag> getAuftragList(String filter){    	

        String sql = "SELECT * FROM auftraege "+filter;        	
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);
        	
        ArrayList<Auftrag> returnList = new ArrayList<>();
        
        for(int rowID = 0; rowID < tbl.getRowCount(); rowID ++){
    		returnList.add(new Auftrag(
    				 (Integer)tbl.getValueAt(rowID,0) //Auftrag_ID
    				,(String)tbl.getValueAt(rowID,1)  //Arbeiten
    				,(Boolean)tbl.getValueAt(rowID,2)  //Erledigt
    				,(Integer)tbl.getValueAt(rowID,3))//Kfz_ID
    		);
        }

        return returnList;        

    }


    
    
    public DefaultTableModel getAuftragListAsTable(){
    	
    	String sql = "SELECT kfz.marke AS Marke"
	 +", kfz.modell AS Modell"
	 +", kfz.kennzeichen AS 'Kennz.'"
	 +", auftraege.arbeiten AS Bemerkung"
	 +", CONCAT(kunde.vorname,' ', kunde.nachname) AS 'K. Name'"
	 +", kunde.kunde_ID AS 'K. ID'"
	 +" FROM auftraege"
	 +" INNER JOIN kfz ON auftraege.kfz_ID = kfz.kfz_ID"
	 +" INNER JOIN kunde ON kunde.kunde_ID = kfz.kunde_ID";
    	
    	System.out.println(sql);
    	
    	return DB.getInstance().tableSelect(sql);
    	
    }
    
public void addAuftragToDB(Auftrag neuerAuftrag){
    	
    	String sql = "INSERT INTO auftraege "
				+ "(arbeiten, kfz_ID, erledigt) VALUES "
				+ " (" + "'" + neuerAuftrag.getArbeiten()+ "'" + 
				", " + "'" + neuerAuftrag.getKfz_ID() + "'" + 
				", false );";
				
    	DB.getInstance().tableInsert(sql);
	}

}
