package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;
import dao.ProductDao;
import dao.ProductDaoImp;

@WebServlet("/ProductManagement")
public class ProductManagement extends HttpServlet {
private ProductDao productDao;
	
	public void init() throws ServletException {
		productDao=new ProductDaoImp();
	}
	 public ProductManagement() {
		super();

}
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String path = request.getServletPath();
			
				List<Product> P = productDao.getAllProducts();
				List<String> imagelist = new ArrayList<String>();
				for (Product p : P){	
				byte[] imgBytes = p.getImg();
				imagelist.add(Base64.getEncoder().encodeToString(imgBytes));
				}
				request.setAttribute("img",imagelist);
				request.setAttribute("product",P);
				request.getRequestDispatcher("products.jsp").forward(request,response);
		}
}
