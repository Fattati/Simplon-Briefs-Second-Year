package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;



import beans.Product;
import dao.ProductDao;
import dao.ProductDaoImp;

@WebServlet("/ProductController")
@MultipartConfig(maxFileSize = 16177215)
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int productId;
	private ProductDao productDao;
	
	public void init() throws ServletException {
		productDao=new ProductDaoImp();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/admin")) {
			request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
		else if (path.equals("/search.do")) {
			String n = request.getParameter("n");
			try {
				List<Product> product = productDao.search("%" +n+ "%");
				List<String> imgList = new ArrayList<String>();
				for (Product p : product) {
					byte[] imgbytes = p.getImg();
					System.out.println(imgbytes);
					imgList.add(Base64.getEncoder().encodeToString(imgbytes));
				}
				request.setAttribute("img", imgList);
				request.setAttribute("product", product);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("admin.jsp").forward(request,response);	
			}		
		}
		else if (path.equals("/delete.do")) {
			int id =Integer.parseInt(request.getParameter("productId"));
			try {
				productDao.delete(id);
				response.sendRedirect("search.do?n=");
				
			} catch (Exception e) {
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
			
		}
		else if (path.equals("/edit.do")) {
			ProductController.productId=Integer.parseInt(request.getParameter("productId"));
			Product p=productDao.getProduct(productId);
			request.setAttribute("product", p);
			request.getRequestDispatcher("productUpdate.jsp").forward(request, response);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		String path = request.getServletPath();
		if(path.equals("/addProduct.do")) {
			String name = request.getParameter("name");
			float quantity = Float.parseFloat(request.getParameter("quantity"));
			float price = Float.parseFloat(request.getParameter("price"));
			InputStream inputStream = null;
			Part filepart = request.getPart("img");
			if (filepart != null) {
				inputStream = filepart.getInputStream();
			}
			byte[] img = IOUtils.toByteArray(inputStream);
			try {
				System.out.println("Succes");
				Product p = productDao.save(new Product(name, price, img, quantity));
				response.sendRedirect("search.do?n=");
				
			} catch (Exception e) {
				System.out.println("Erreur");
				request.setAttribute("erreur",e.getMessage());
				request.getRequestDispatcher("admin.jsp").forward(request,response);
				
			}
			
		}
		else if(path.equals("/update.do")) {
			String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			float quantity = Float.parseFloat(request.getParameter("quantity"));
			InputStream inputStream = null;
	        Part filePart = request.getPart("img");
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] img = IOUtils.toByteArray(inputStream);
			try {
				System.out.println(name + " " + price + " " + quantity + " " );
				System.out.println("Succes");
				Product Prd = productDao.update(new Product(ProductController.productId,name, price, img, quantity));
				response.sendRedirect("search.do?n=");
			}catch(SQLException e){
				System.out.println(e.getMessage());
				request.setAttribute("erreur",e.getMessage());
				request.getRequestDispatcher("productUpdate.jsp").forward(request,response);
			}
		}

	}
}
