package boundary;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import logiclayer.ApartmentLogicImpl;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Configuration cfg = null;

	private String templateDir = "/WEB-INF/templates";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}

	public void init() {
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.25) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		cfg = new Configuration(Configuration.VERSION_2_3_25);

		// Specify the source where the template files come from.
		cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);

		// Sets how errors will appear.
		// This handler outputs the stack trace information to the client, formatting it so 
		// that it will be usually well readable in the browser, and then re-throws the exception.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
	}

	/*
	 * This method is called by the doGet method. This method will create and process the template
	 * used to display the search results or an error page if the user input is invalid.
	 */
	public void runTemplate(HttpServletRequest request, HttpServletResponse response) {

		Template template = null;
		String templateName = null; //template to be generated

		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
		
		// The following Strings are used to check for a null value.
		String signIn = request.getParameter("sign in"); // home page sign in button
		String signUp = request.getParameter("sign up"); // home page sign up button
		String register = request.getParameter("register"); // signUp.ftl register button
		String login = request.getParameter("login"); // signIn.ftl login button
		String contact = request.getParameter("contact"); // home page contact button
		String about = request.getParameter("about"); // home page about button

		//begin checks to see what the input is
		if(signUp != null){ // check to see if user clicked the sign up button on the home page
			templateName = "signUp.ftl";
			
		} else if (register!= null){ // check to see if user clicked the register button on signUp.ftl
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			boolean valid = true; // boolean check for valid inputs
			
			// checking for valid inputs (user must enter a uga.edu email) - THIS MIGHT BE JAVASCRIPT INSTEAD
			try{
			} catch (NumberFormatException e){
				valid = false;
			}
			
			int r = 0;
			if (valid == true){ // enter here if the inputs are in fact valid
				try{
					r = ApartmentLogicImpl.newUser(request, response, name, email, password); // newUser method is called to add a new user into the database
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
			if (r == 0){
				//error inserting the new user into the database. 
			} else{
				root.put("name", name);
				root.put("registerSuccessful","yes");
				templateName = "signIn.ftl";
			}
			
		} else if (signIn != null){ // check to see if user clicked the sign in button on the home page
			templateName = "signIn.ftl";
			
		} else if (login != null){ // check to see if user clicked the login button on signIn.ftl
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			root.put("email", email);
			
			boolean loggedIn = false;
			try {
				loggedIn = ApartmentLogicImpl.verifyLogin(request, response, email, password); // check for correct email and password
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			if (loggedIn) { // enter here if successfully login
				templateName = "welcome.ftl";
			} else {
				root.put("failedLogin","yes");
				templateName = "signIn.ftl";
			}
		} else if (contact != null){
			templateName = "contact.ftl";
		} else if (about != null){
			templateName = "about.ftl";
		}
	
	
		
		try {
			template = cfg.getTemplate(templateName);
			response.setContentType("text/html");
			Writer out = response.getWriter();
			template.process(root, out); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			runTemplate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
