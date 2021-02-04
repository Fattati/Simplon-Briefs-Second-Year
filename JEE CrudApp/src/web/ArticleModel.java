package web;

import java.util.ArrayList;
import java.util.List;

import entities.Article;

public class ArticleModel {
	private String n;
	private List<Article> articles=new ArrayList<Article>();
	
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
