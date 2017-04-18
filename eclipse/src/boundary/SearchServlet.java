package boundary;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

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

/**
 * Servlet implementation class FreeMarkerServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Configuration cfg = null;

	private String templateDir = "/WEB-INF/template";
	
	public String username = "";
	
	ArrayList<String> thoughtsList = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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

	public void runTemplate(HttpServletRequest request, HttpServletResponse response) {

		// You can use this structure for all of your objects to be sent to browser
		ApartmentLogicImpl apartmentSQL = new ApartmentLogicImpl();
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
		System.out.println("Entered the Servlet");
		
		//The table for all the code.
		String table = "";
		
		String location = request.getParameter("location");
		String bedNumber = request.getParameter("bedNumber");
		int numBeds = Integer.parseInt(bedNumber);
		String semester = request.getParameter("semester");
		String price = request.getParameter("price");
		if(price.equals("range1")){
			table = apartmentSQL.getApartmentSearch(location, numBeds, semester, 0, 399);
		}
		if(price.equals("range2")){
			table = apartmentSQL.getApartmentSearch(location, numBeds, semester, 400, 599);
		}
		if(price.equals("range3")){
			table = apartmentSQL.getApartmentSearch(location, numBeds, semester, 600, 799);
		}
		if(price.equals("range4")){
			table = apartmentSQL.getApartmentSearch(location, numBeds, semester, 800);
		}
		
		System.out.println(table);
		
		System.out.println("This is the location: " + location);
		System.out.println("This is the number of Beds: " + bedNumber);
		System.out.println("This is the semester: " + semester);
		System.out.println("This is the price: " + price);
		//System.out.println("This is the location: " + location);
		//apartmentSQL.getApartmentSearch();
		
		try {
			response.setContentType("text/html");
			response.getWriter().write(table);
			
		} catch (IOException e) {
			e.printStackTrace();
		} //catch (TemplateException e) {
			//e.printStackTrace();
		//}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered Get");
		runTemplate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered Post");
		doGet(request, response);
	}
	

}
