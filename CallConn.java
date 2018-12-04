package Ticket_dbms;

import java.sql.Connection;
import java.sql.DriverManager;

public class CallConn {

	public Connection call(){
		Connection c=null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_dbms","root","");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			return c;
}
}
