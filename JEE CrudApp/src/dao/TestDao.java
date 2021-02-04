package dao;

import entities.Article;

public class TestDao {

	public static void main(String[] args) {
		ArticleDaoImp dao=new ArticleDaoImp();
		Article a5=dao.save(new Article("article5"));

	}

}
