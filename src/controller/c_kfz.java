package controller;

import general.Kfz;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.DB;

public class c_kfz {

	private static c_kfz INSTANCE;

	public static c_kfz getInstance() {

		if (INSTANCE == null) {

			INSTANCE = new c_kfz();

		}

		return INSTANCE;

	}

	public ArrayList<Kfz> getKfzList(String filter) {

		String sql = "SELECT * FROM kfz " + filter;
		DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

		ArrayList<Kfz> returnList = new ArrayList<>();

		for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
			returnList.add(new Kfz((Integer) tbl.getValueAt(rowID, 0) // Kfz_Id
					, (String) tbl.getValueAt(rowID, 1) // Marke
					, (String) tbl.getValueAt(rowID, 2) // Modell
					, (String) tbl.getValueAt(rowID, 3) // Kennzeichen
					, (Integer) tbl.getValueAt(rowID, 4))// Kunden_ID
					);
		}

		return returnList;
	}

	public void addKfzToDB(Kfz neuesKfz) {

		String sql = "INSERT INTO kfz "
				+ "(marke, modell, kennzeichen, kunde_ID) VALUES " + " (" + "'"
				+ neuesKfz.getMarke() + "'" + ", " + "'" + neuesKfz.getModell()
				+ "'" + ", " + "'" + neuesKfz.getKennzeichen() + "'" + ", "
				+ neuesKfz.getKunde_ID() + ");";
		DB.getInstance().tableInsert(sql);
	}

}
