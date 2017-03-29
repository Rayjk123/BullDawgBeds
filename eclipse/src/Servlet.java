package boundary;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class Servlet
 */
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
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		// This handler outputs the stack trace information to the client, formatting it so 
		// that it will be usually well readable in the browser, and then re-throws the exception.
		//		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		// Specifies if TemplateException-s thrown by template processing are logged by FreeMarker or not. 
		//		cfg.setLogTemplateExceptions(false);
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
		
		String action = request.getParameter("action");		

		
		//begin checks to see what the input is
		if("signIn".equals(action)){
			
		}
		if ("Login".equals(action)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String query = "SELECT 1 FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
			
			boolean loggedIn = verifyLogin(query); // check for username and password
				
				if (loggedIn) { // enter here if successfully login
					templateName = "welcome.ftl";
					root.put("username", username);
					
					HttpSession session = request.getSession();
					synchronized(session) {
						String sessionID = session.getId();
						Date sessionDate = new Date(session.getCreationTime());
						Integer accessCount = (Integer)session.getAttribute("accessCount");
						if (accessCount == null) {
						accessCount = 0;
						} else {
						accessCount = accessCount + 1; 
						}
						
						session.setAttribute("sessionID", sessionID);
						session.setAttribute("accessCount", accessCount);
						
						root.put("sessionID", sessionID);
						root.put("sessionDate", sessionDate);
						root.put("accessCount", accessCount);
						}
					
					
				} else {//not found
					templateName = "login.ftl";
					root.put("loginFailed", "yes");
				}
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
