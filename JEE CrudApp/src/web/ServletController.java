package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.ArticleDao;
import dao.ArticleDaoImp;
import entities.Article;

public class ServletController extends HttpServlet {
	private ArticleDao metier;
	
	public void init() throws ServletException {
		metier=new ArticleDaoImp();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if (path.equals("/search.do")) {
			String n=request.getParameter("name");
			ArticleModel model=new ArticleModel();
			model.setN(n); 
			List<Article> articles=metier.search("%"+n+"%");
			model.setArticles(articles);
			request.setAttribute("model", model);
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if (path.equals( "/add.do")) {
			request.getRequestDispatcher("addArticle.jsp").forward(request, response);	
		}
		else if (path.equals("/saveArticle.do")&&(request.getMethod().equals("POST"))) {
			String name=request.getParameter("name");
			Article a=metier.save(new Article(name));
			request.setAttribute("article", a);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else if (path.equals("/delete.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			metier.delete(id);
			//request.getRequestDispatcher("articles.jsp").forward(request, response);	
			response.sendRedirect("search.do?name=");
		}
		else if (path.equals("/edit.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			Article a=metier.getArticle(id);
			request.setAttribute("article", a);
			request.getRequestDispatcher("editArticle.jsp").forward(request, response);
		}
		else if (path.equals("/updateArticle.do")&&(request.getMethod().equals("POST"))) {
			Long id=Long.parseLong(request.getParameter("id"));
			String name=request.getParameter("name");
			Article a=new Article(name);
			a.setId(id);
			metier.update(a);
			request.setAttribute("article", a);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 

	}
}
