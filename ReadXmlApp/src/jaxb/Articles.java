package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles {

	@XmlElement
	List<Article> article = new ArrayList<Article>();

	public List<Article> getArticles() {
		return article;
	}

	public void setArticles(List<Article> articles) {
		this.article = articles;
	}

	public Articles() {
		super();
	}

}
