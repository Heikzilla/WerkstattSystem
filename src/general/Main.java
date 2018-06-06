package general;

import database.DB;
import gui.Window;
import gui.home.MainPanel;

public class Main {

	private static final String server = "localhost";
	private static final String database = "autoreparaturDB";
	private static final String user = "root";
	private static final String password = "";
	private static final int port = 3306;

	public static void main(String[] args) {

		DB.getInstance().connectToDB(server, port, database, user, password);
		Window.getInstance().loadView(new MainPanel());
		Window.getInstance().toggleVisible();

	}

}
