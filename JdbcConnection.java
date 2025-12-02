package JdbcConnection;

import java.sql.*;
import java.util.*;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		while(true) {
			System.out.println("Press 1 to CREATE");
			System.out.println("Press 2 to DISPLAY");
			System.out.println("Press 3 to UPDATE");
			System.out.println("Press 4 to DELETE");
			System.out.println("Press 5 to EXIT");
						
			System.out.println();
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter your choice: ");
			int choice=scan.nextInt();
			
			
			switch(choice) {
			
			
			case 1:
				create();
				System.out.println();
				break;
				
			case 2:
				read();
				System.out.println();
				break;
				
			case 3:
				update();
				System.out.println();
				break;
			case 4:
				delete();
				System.out.println();
				break;
			case 5:
				System.exit(0);
			}
		}
		
		
	}



public static void create() throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbc";
	String name="root";
	String password="root";
	
	Scanner scan=new Scanner(System.in);
	System.out.print("Enter Student id - ");
	int id=scan.nextInt();			
			
	scan.nextLine();
	System.out.print("Enter Student name - ");
	String stdName=scan.nextLine();			
	
	Connection con=DriverManager.getConnection(url,name,password);
	
	String query="INSERT INTO STUDENT VALUES(?,?)";
	
	PreparedStatement ps=con.prepareStatement(query);
	
	ps.setInt(1, id);
	ps.setString(2, stdName);
	
	int val=ps.executeUpdate();
	System.out.println(val+" Rows CREATED");
	
	con.close();
	
}


public static void read(){
	String url= "jdbc:mysql://localhost:3306/jdbc";
	String name="root";
	String password="root";
	
	Connection con=DriverManager.getConnection(url,name,password);
	
	Statement st=con.createStatement();
	
	String query="Select * from Student";
	
	ResultSet rs=st.executeQuery(query);
	
	while(rs.next()) {
		System.out.print(rs.getInt(1)+"  ");
		System.out.print(rs.getString(2));
		System.out.println();
	}
	con.close();
}


public static void update(){
	String url= "jdbc:mysql://localhost:3306/jdbc";
	String name="root";
	String password="root";
	
	Scanner scan=new Scanner(System.in);
	System.out.print("Enter Student id to UPDATE - ");
	int id=scan.nextInt();			
	
	scan.nextLine();
	System.out.print("Enter Student new name to UPDATE - ");
	String stdName=scan.nextLine();			

	Connection con=DriverManager.getConnection(url,name,password);
	
	String query="UPDATE STUDENT SET Name=? WHERE RegNo=?";
	
	PreparedStatement ps=con.prepareStatement(query);
	
	ps.setString(1, stdName);
	ps.setInt(2, id);
	
	int val=ps.executeUpdate();
	System.out.println(val+" Rows UPDATED");
	
	con.close();
	
}



public static void delete(){
	String url= "jdbc:mysql://localhost:3306/jdbc";
	String name="root";
	String password="root";
	
	Scanner scan=new Scanner(System.in);
	
	System.out.print("Enter Student id to DELETE - ");
	int id=scan.nextInt();						
	
	Connection con=DriverManager.getConnection(url,name,password);
	
	String query="DELETE FROM STUDENT WHERE RegNo=?";
	
	PreparedStatement ps=con.prepareStatement(query);
	
	ps.setInt(1, id);
	
	int val=ps.executeUpdate();
	System.out.println(val+" Rows DELETED");
	
	con.close();
}

}



