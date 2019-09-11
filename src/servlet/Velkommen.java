package servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.linker;

/**
 * Servlet implementation class Velkommen
 */
@WebServlet("/index")
public class Velkommen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Locale locale;

    /**
     * Default constructor. 
     */
    public Velkommen() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/velkommen.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valg = request.getParameter("sprak");
		
		switch(valg) {
		case "norsk":{
			locale = new Locale("no");
			break;
		}case "engelsk":{
			locale = new Locale("en");
			break;
		}case "fransk":{
			locale = new Locale("fr");
			break;
		}
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("locale", locale);
		response.sendRedirect(linker.products);
	}

}
