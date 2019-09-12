package servlet;

import java.io.IOException;
import java.util.ArrayList;
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

import eao.DescriptionEAO;
import eao.ProductEAO;
import objekt.Description;
import objekt.Product;
import objekt.ProduktDesc;

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
    @EJB
    private DescriptionEAO descriptionEAO;
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
		List<Description> descriptions = descriptionEAO.getAllDescriptions();
		List<ProduktDesc> productsDesc = mergeDescProduct(products, descriptions, locale);
		session.setAttribute("products", productsDesc);
		System.out.println(locale.getLanguage());
		session.setAttribute("test", bundle.getString("test"));
		request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
	}

	



	private List<ProduktDesc> mergeDescProduct(List<Product> products, List<Description> descriptions, Locale locale) {
		List<Description> rettDescription = getLocaleDesc(descriptions, locale);
		List<ProduktDesc> output = new ArrayList<ProduktDesc>();
		for(int i = 0; i < products.size(); i++) {
			for(int j = 0; j < rettDescription.size(); j++) {
				if(products.get(i).getPno() == rettDescription.get(j).getPno()) {
					ProduktDesc e = new ProduktDesc(products.get(i), rettDescription.get(j).getText());
					output.add(e);
				}
			}
		}
		return output;
	}



	private List<Description> getLocaleDesc(List<Description> descriptions, Locale locale) {
		List<Description> output = new ArrayList<Description>();
		String lokal = locale.getLanguage();
		for(int i = 0; i < descriptions.size(); i++) {
			if(descriptions.get(i).getLangCode().equals(lokal)) {
				output.add(descriptions.get(i));
			}
		}
		return output;
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
