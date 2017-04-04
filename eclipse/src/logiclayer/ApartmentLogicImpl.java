package logiclayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistlayer.DbAccess;

public class ApartmentLogicImpl {
	


	public static int newUser(HttpServletRequest request, HttpServletResponse response, String name, String email, String password) {
		String query = "INSERT INTO users (name, email, password) Values('"+name+"', '"+email+"', '"+password+"')";
		int r = 0;
		try{
			r = DbAccess.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
	
	public static boolean verifyLogin(HttpServletRequest request, HttpServletResponse response, String email, String password) throws SQLException {
		String query = "SELECT 1 FROM users WHERE email = '"+email+"' AND password = '"+password+"'";
		Connection con = DbAccess.connect();
		ResultSet rs = null;
		boolean loggedIn = false;
		
		try{
			rs = DbAccess.retrieve(con, query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		if (rs.next()) { // enter here if successfully login
			loggedIn = true;
		} 
			
		DbAccess.disconnect(con);
		return loggedIn;
	}
	
	
	
}
