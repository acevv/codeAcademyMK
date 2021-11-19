package main;

import java.io.IOException;

import java.util.HashMap;

import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import jaxb.Article;
import jaxb.Articles;
import jaxb.ArticlesJAXB;

public class Main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		String filePath = "/Users/acev/Documents/DESKTOP!/ACEV Aleksandar/Coding Material/CodeAcademy Mk 2021/Home Work/HW 1/products.xml";
		ArticlesJAXB jaxb = new ArticlesJAXB();

		Articles lista = jaxb.unmarshall(filePath);

		for (Article article : lista.getArticles()) {
			System.out.println(article);
		}

		System.out.println("==================================================================================");
		System.out.println("Broj na artikli: " + lista.getArticles().size());
		System.out.println("==================================================================================");

		minMax(lista);

		Article art1 = new Article();
		art1.setId("10004");
		art1.setName("Skopsko");
		art1.setPrice("50mkd");
		art1.setWeight("2l");
		art1.setType("drink");
		art1.setQuantity("1");

		Article art2 = new Article();
		art2.setId("10005");
		art2.setName("Fanta");
		art2.setPrice("50mkd");
		art2.setWeight("1l");
		art2.setType("drink");
		art2.setQuantity("2");

		lista.getArticles().add(art1);
		lista.getArticles().add(art2);

		jaxb.marshall(lista);

		countDuplicates(lista);

	}

	private static Integer getPriceAsInt(String priceWithMkd) {

		Integer x = 0;

		if (priceWithMkd.endsWith("mkd")) {

			char[] listFromStrings = priceWithMkd.toCharArray();
			Integer length = listFromStrings.length;

			String value = priceWithMkd.substring(0, length - 3);

			Integer value2 = Integer.parseInt(value);
			x += value2;
		}
		return x;

	}

	public static void minMax(Articles lista) {
		HashMap<String, Double> priceMap = new HashMap<>();

		for (Article article : lista.getArticles()) {
			Integer articlePrice = getPriceAsInt(article.getPrice());
			Double quantity = Double.valueOf(article.getQuantity());
			priceMap.put(article.getId(), articlePrice * quantity);
		}

		Set<String> keys = priceMap.keySet();
		Double min = 0.00;
		Double max = 0.00;

		String minArtKey = "";
		String maxArtKey = "";
		Boolean flag = true;
		for (String key : keys) {
			if (flag) {
				min = priceMap.get(key);
				minArtKey = key;
				max = priceMap.get(key);
				maxArtKey = key;
				flag = false;
			}

			if (min > priceMap.get(key)) {

				min = priceMap.get(key);
				minArtKey = key;
			}

			if (max < priceMap.get(key)) {
				max = priceMap.get(key);
				maxArtKey = key;
			}

		}

		for (Article article : lista.getArticles()) {
			if (minArtKey.equals(article.getId())) {
				System.out.println("Lowest price has: " + article.getName() + ", with price of " + article.getPrice()
						+ " per " + article.getWeight());
			} else if (maxArtKey.equals(article.getId())) {
				System.out.println("Highest price has: " + article.getName() + ", with price of " + article.getPrice()
						+ " per " + article.getWeight());
			}
		}

	}

	public static void countDuplicates(Articles lista) {

		HashMap<String, Integer> count = new HashMap<>();
		Integer counter = 0;

		for (int i = 0; i < lista.getArticles().size(); i++) {

			for (Article article : lista.getArticles()) {
				if (lista.getArticles().get(i).getName().equals(article.getName())) {
					counter++;

				}

				count.put(lista.getArticles().get(i).getName(), counter);
			}
			counter = 0;

		}
		System.out.println(count);

	}

}