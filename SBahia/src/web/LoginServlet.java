package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import services.LoginForm;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
	}
	public boolean passwordValidation(String password) {
		boolean test = true;
		if(password.length() < 8){
			test = false;
		}	
		return test;
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginForm loginForm= new LoginForm();
        if(!passwordValidation(password)) {
			request.setAttribute("error","email or password incorect");
			request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
			
		
        try {
        	User user = loginForm.checkLogin(email, password);
        	String destPage = "index.jsp";
        	
        	 if (user != null) {
                 HttpSession session = request.getSession();
                 session.setAttribute("user", user);
                 if (user.getRole().equals("admin")) {
                	 RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                	 dispatcher.forward(request, response);
				}
                 else if (user.getRole().equals("client")) {
                	 /*RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
                	 dispatcher.forward(request, response);*/
                	 response.sendRedirect("/SBahia/ProductManagement");
				}
                 } 
        	 else {
                 String message = "Invalid email/password";
                 request.setAttribute("message", message);
             }
//        	 RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//             dispatcher.forward(request, response);
              
         } catch (SQLException ex) {
             throw new ServletException(ex);
         }
	}
	
	}
}

