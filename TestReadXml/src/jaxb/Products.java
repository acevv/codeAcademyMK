package jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {

	@XmlElement
	List<Product> product = new ArrayList<Product>();

	public List<Product> getProducts() {
		return product;
	}

	public void setProducts(List<Product> products) {
		this.product = products;
	}

	public Products() {
		super();
	}

	@Override
	public String toString() {
		return "Products [products=" + product + "]";
	}

}
