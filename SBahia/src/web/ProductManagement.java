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

import org.apache.tomcat.util.descriptor.web.ContextResourceEnvRef;

import beans.Product;
import beans.User;
import dao.ProductDao;
import dao.ProductDaoImp;
import dao.VoteDao;
import dao.VoteDaoImp;

@WebServlet("/ProductManagement")
public class ProductManagement extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	VoteDao vr;
	VoteModel vModel;
private ProductDao productDao;
public static final String ATT_SESSION_USER = "UserSession";
	
	public void init() throws ServletException {
		productDao=new ProductDaoImp();
		
		
	}
	 public ProductManagement() {
		super();
		vr=new VoteDaoImp();
		vModel= new VoteModel();

}
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String path = request.getServletPath();
			
				List<Product> P = productDao.getAllProducts();
				List<String> imagelist = new ArrayList<String>();
				List<Integer> voteNumber = new ArrayList<Integer>();
				for (Product p : P){	
					vModel = vr.getProductVote(p.getProductId());
					voteNumber.add(vModel.getVoteNumber());
				byte[] imgBytes = p.getImg();
				imagelist.add(Base64.getEncoder().encodeToString(imgBytes));
				}
				request.setAttribute("img",imagelist);
				request.setAttribute("product",P);
				request.setAttribute("voteNumber", voteNumber);
				request.getRequestDispatcher("products.jsp").forward(request,response);
				if (path.equals("/like.test")){
					int productId = Integer.parseInt(request.getParameter("productId"));
					User user = (User) session.getAttribute("user" );
					System.out.println("id : " +  productId + " id_user" + user.getUserId());
					try {
						vr.setProductVote(user.getUserId(),productId);
						response.sendRedirect("/SBahia/ProductManagement");
					}catch (Exception e) {
						response.sendRedirect("/SBahia/ProductManagement");
					}	
				}
		}
	 
}
