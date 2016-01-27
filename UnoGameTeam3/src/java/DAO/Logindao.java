
package DAO;

import Model.logindto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Logindao {  
public static boolean validate(String userid,String password){  
boolean status=false;  
try{  
 String driver = "com.mysql.jdbc.Driver";
    String connection = "jdbc:mysql://localhost:3306/unogame";
    String user = "root";
    String password1 = "password";
    Class.forName(driver);
    Connection con = DriverManager.getConnection(connection, user, password1);
    PreparedStatement ps;
//    if (!con.isClosed()) {
//      con.close(); 
//    }
      
ps=con.prepareStatement(  
"select * from login where userid=? and password=?");  
ps.setString(1,userid);  
ps.setString(2,password);  
      
ResultSet rs=ps.executeQuery();  
if(rs.next())
    //status=rs.next(); 
    status=true;

          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
//	private static Connection connection;
//	private static Statement statement;
//	private ResultSet rs;
//	private static void openConnection() {
//		try {
//			 String driver = "com.mysql.jdbc.Driver";
//    String connection = "jdbc:mysql://localhost:3306/unogame";
//    String user = "root";
//    String password1 = "password";
//    Class.forName(driver);
//    Connection con = DriverManager.getConnection(connection, user, password1);
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private static void closeConnection() {
//		try {
//			statement.close();
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	/* (non-Javadoc)
//	 * @see dao.StudentDAO#createStudent(model.StudentDetailsDTO)
//	 */
//	
//	public int createplayer(logindto s) throws SQLException {
//		openConnection();
//		String ins = "INSERT INTO login(userid,password) "
//				+ "VALUES ("
//				+ "\""
//				+ s.getUserid()
//				+ "\", \""
//				+ s.getPassword()
//				+ "\",\""
//				+");";
//		int result = statement.executeUpdate(ins);
//		closeConnection();
//		return result;
//	}
}



 
