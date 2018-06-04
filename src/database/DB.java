package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DB {

	private static DB instance;	
	private static String serverName;
	private static String dbName;
	private static String userName;
	private static String userPassword;
	private static String connectionString;
	private static int serverPort;
	
	
	
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
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		DefaultTableModel tb = null;
		try {
			con = DriverManager.getConnection(connectionString, userName, userPassword);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			tb = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
				System.out.println("TEST2");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		System.out.println(tb.getValueAt(1, 0));
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
	
	public Object objectSelect(String sql){
	
		
		return tableSelect(sql).getValueAt(1, 0);
		
		
	}
	
	
}
