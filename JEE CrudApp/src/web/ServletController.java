package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.ArticleDaoImp;

public class ServletController extends HttpServlet {
	private ArticleDao metier;
	
	public void init() throws ServletException {
		metier=new ArticleDaoImp();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("articles.jsp").forward(request, response);
	}
}
