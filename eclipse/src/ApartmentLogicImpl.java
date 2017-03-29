package logiclayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApartmentLogicImpl {
	
	/*
	 * This method is called from Servlet.java. This method is called when the user clicks on an option on the home page, and
	 * this method will determine which action the user wants to perform. Depending on the action the user wants to perform, this
	 * method will return the corresponding template name for that page.
	 */
	public static String getTemplateName (String action){
		String templateName = null;
	
		if("View movie titles of a selected genre".equals(action)){ 
			templateName = "findMovies.ftl";
				
		} else if("View movie information".equals(action)) {
			templateName = "viewMovieInfo.ftl";

		} else if("Enter a new movie".equals(action)) {
			templateName = "newMovie.ftl";
				
		} else if("Enter a movie review".equals(action)){
			templateName = "newReview.ftl";
			
		} else if ("Delete a movie review".equals(action)){
			templateName = "deleteMovieReview.ftl";
			
		} else if ("Delete a movie".equals(action)){
			templateName = "deleteMovie.ftl";
			
		} else if ("Edit a movie".equals(action)){
			templateName = "editMovie.ftl";
		}  // end of if statements
		return templateName;
	}
	
	
	
}
