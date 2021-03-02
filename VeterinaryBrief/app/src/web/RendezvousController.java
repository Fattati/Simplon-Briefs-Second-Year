package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Rendezvous;
import beans.User;
import dao.RendezvousDao;

@WebServlet("/Rendezvous")
public class RendezvousController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RendezvousDao rendezvousDao = new RendezvousDao();
			String title = request.getParameter("title");
			String animalType = request.getParameter("animalType");
			String DateS = request.getParameter("rendezvousDate");
			try {
				Date rendezvousDate = new SimpleDateFormat("MM/dd/yyyy").parse(DateS);
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				System.out.println(user.getUser_id());
				Rendezvous rendezvous = new Rendezvous(title, animalType, rendezvousDate, user);
				rendezvousDao.saveRendezvous(rendezvous);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("rendezvous.jsp");
	            dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
		
	}

}
