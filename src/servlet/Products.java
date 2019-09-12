package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eao.ProductEAO;
import objekt.Product;

/**
 * Servlet implementation class Products
 */

@WebServlet("/products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle;
	private Locale locale;
    @EJB
    private ProductEAO productEAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }
   


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		locale = (Locale)session.getAttribute("locale");
		bundle = ResourceBundle.getBundle("siteText", locale);
		List<Product> products = productEAO.gettAllProducts();
		session.setAttribute("products", products);
		System.out.println(locale.getLanguage());
		session.setAttribute("test", bundle.getString("test"));
		request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
