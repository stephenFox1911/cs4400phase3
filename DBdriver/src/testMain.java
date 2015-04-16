import java.sql.*;

public class testMain {
	public static void main(String args[]) {
		
		System.out.println("Create Driver");
		DBdriver drive = new DBdriver();
		ResultSet results = drive.sendQuery("SELECT * FROM test");
		
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