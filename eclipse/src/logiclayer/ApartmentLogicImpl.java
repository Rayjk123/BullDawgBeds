package logiclayer;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistlayer.DbAccess;

public class ApartmentLogicImpl {
	
	/*
	 * This method is called from the Servlet, and it creates a query to that is executed to enter a new user into the database.
	 */
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
	
	/*
	 * This method is called from the Servlet, and it creates a query to that is executed to check if the user's email
	 * and password exists in the database.
	 */
	public static boolean verifyLogin(HttpServletRequest request, HttpServletResponse response, String email, String password) {
		String query = "SELECT 1 FROM users WHERE email = '"+email+"' AND password = '"+password+"'";
		Connection con = DbAccess.connect();
		ResultSet rs = null;
		boolean loggedIn = false;
		
		try{
			rs = DbAccess.retrieve(con, query);
			if (rs.next()) { // enter here if successfully login
				loggedIn = true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	

			
		DbAccess.disconnect(con);
		return loggedIn;
	}

	public static boolean duplicateEmail(HttpServletRequest request, HttpServletResponse response, String email) {
		String query = "SELECT * FROM users WHERE email = '"+email+"'";
		Connection con = DbAccess.connect();
		ResultSet rs = null;
		boolean duplicate = false;
		
		try{
			rs = DbAccess.retrieve(con, query);
			if (rs.next()) { // enter here if the email exists in the database
				duplicate = true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
			
		DbAccess.disconnect(con);
		return duplicate;
	}

	public static boolean validEmail(String email) {
		boolean valid = false;
		
		if(email.contains("@uga.edu")){
			valid = true;
		}
		return valid;
	}

	public static String getLoginName(HttpServletRequest request, HttpServletResponse response, String email) {
		String query = "SELECT name FROM users WHERE email = '"+email+"'";
		Connection con = DbAccess.connect();
		ResultSet rs = null;
		String name = null;
		
		try{
			rs = DbAccess.retrieve(con, query);
			if (rs.next()) { // enter here if the name was found
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		DbAccess.disconnect(con);
		return name;
	}

	
	
}
