package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import dao.UserDaoImp;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
    private UserDao userDao;
	public void init() throws ServletException {
		userDao=new UserDaoImp();
	}
	public RegisterServlet() {
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = "client";
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		
		String userRegistered = userDao.saveUser(user);
		if (userRegistered.equals("Success")) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
			else {
				request.setAttribute("errMessage", userRegistered);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		}
		
		
	}
	
	

