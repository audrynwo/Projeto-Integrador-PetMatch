package application;

import java.sql.Connection;
import db.DB;

public class Main {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		if(conn != null)
			System.out.println("CONSEGUI SOCORROOOOOOOOOOOO!!! :D");
		DB.closeConnection();
	}

}
