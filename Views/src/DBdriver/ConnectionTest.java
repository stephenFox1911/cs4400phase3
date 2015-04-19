package DBdriver;

import java.sql.ResultSet;

public class ConnectionTest {
	public static void main(String args[]) {
		
		System.out.println("Create Driver");
		DBdriver drive = new DBdriver();
		ResultSet results = drive.sendQuery("SELECT * FROM AUTHOR");
		
		try {
			while(results.next()){
				String name = results.getString("name");
				System.out.println(name);
			}
		} catch(Exception e) {
			System.out.println("Error");
		}
		drive.closeConnection();
	}
}