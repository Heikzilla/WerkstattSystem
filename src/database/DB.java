package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DB {

	/*
	 * Handelt die eigene Instance.
	 * Es kann keine neue Instance erstellt werden.
	 * Aufruf ueber DB.getInstance()
	 * 
	 * Zur Initialisierung muss connectToDB() aufgerufen werden.
	 * 
	 * 
	 * 
	 */
	
	private static DB instance;	
	private static String serverName;
	private static String dbName;
	private static String userName;
	private static String userPassword;
	private static String connectionString;
	private static int serverPort = 0;
	
	
	
	private DB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
	}
	
	public static DB getInstance(){
		
		if(instance == null){
			
			instance = new DB();
		}
		
		return instance;
		
	}
	
	
	public void connectToDB(String server, int port, String database, String user, String password){
		
		serverName = server;
		dbName = database;
		serverPort = port;
		userName = user;
		userPassword = password;
		
		connectionString = "jdbc:mysql://"
						+serverName
						+":"
						+String.valueOf(serverPort)
						+"/"
						+dbName;

	}
	
	public DefaultTableModel tableSelect(String sql){
		
		if(!isConnected())
			return null;
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DefaultTableModel tb = null;
		try {
			con = DriverManager.getConnection(connectionString, userName, userPassword);
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			tb = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		
		return tb;
		
	}
	
	private static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	/*
	 * Gibt den Skalarwert fuer das ausgefuehrte Select aus
	 */
	public Object objectSelect(String sql){
	
		
		return tableSelect(sql).getValueAt(1, 0);
		
		
	}
	
	
	private boolean isConnected(){
		
		return serverName != null
				&& dbName != null 
				&& userName != null 
				&& userPassword != null 
				&& connectionString != null 
				&& serverPort != 0;
		
	}
	
	
}
