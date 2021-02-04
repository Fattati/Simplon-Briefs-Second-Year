package dao;


import java.util.List;

import entities.Article;

public interface ArticleDao {
	public Article save(Article a);
	public List<Article> search (String n);
	public Article update(Article a);
	public void delete(long id);

}
