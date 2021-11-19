package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jaxb.Product;
import jaxb.Products;
import jaxb.ProductsJAXB;

public class Main {

	public static void main(String[] args) {

		// Prv del od zadacata
		ProductsJAXB jaxb = new ProductsJAXB();

		Products list = jaxb.unmarshall("/Users/acev/Desktop/test/products.xml");

		for (Product product : list.getProducts()) {
			System.out.println(product);
		}

		System.out.println("Vkupno produkti ima: " + list.getProducts().size());

		minMax(list);

		// prv obid dinamicki
//		tipoviNaProdukti(list);

		System.out.println("-----------------------------------------");

		// vtor obid avtomatski
//		tipoviNaproduktiAuto(list);

		System.out.println(sameType(list));

		// Vtor del od zadacata
		Product product1 = new Product();
		product1.setId("500001");
		product1.setName("Getorade");
		product1.setType("newProduct");
		product1.setPrice("100MKD");
		product1.setWeight("1l");
		product1.setQuantity("1");

		Product product2 = new Product();
		product2.setId("500002");
		product2.setName("RedBull");
		product2.setType("newProduct");
		product2.setPrice("150MKD");
		product2.setWeight("0.5l");
		product2.setQuantity("2");

		Product product3 = new Product();
		product3.setId("500003");
		product3.setName("Hell");
		product3.setType("newProduct");
		product3.setPrice("50MKD");
		product3.setWeight("0.25l");
		product3.setQuantity("2");

		Product product4 = new Product();
		product4.setId("500004");
		product4.setName("Monster");
		product4.setType("newProduct");
		product4.setPrice("200MKD");
		product4.setWeight("1l");
		product4.setQuantity("1");

		Products produkti = new Products();
		produkti.getProducts().add(product1);
		produkti.getProducts().add(product2);
		produkti.getProducts().add(product3);
		produkti.getProducts().add(product4);

		jaxb.marshall(produkti);

	}

	public static void tipoviNaproduktiAuto(Products list) {

		ArrayList<String> types = new ArrayList<String>();

		for (Product product : list.getProducts()) {
			if (types.contains(product.getType())) {

			} else {
				types.add(product.getType());

			}

		}

		HashMap<String, Integer> productsFromSameType = new HashMap<String, Integer>();
		HashMap<String, ArrayList<Product>> typeMap = new HashMap<String, ArrayList<Product>>();
		ArrayList<Product> listaSoProdukti = new ArrayList<Product>();
		ArrayList<Product> temp = new ArrayList<Product>();

		for (int i = 0; i < types.size(); i++) {
			Integer counter = 0;

			for (Product product : list.getProducts()) {
				if (product.getType().equals(types.get(i))) {
					counter++;
					productsFromSameType.put(product.getType(), counter);
					temp.add(product);
					listaSoProdukti = temp;

				}

			}
			System.out.println(temp);
			System.out.println(types.get(i));
//			System.out.println(listaSoProdukti);
			typeMap.put(types.get(i), listaSoProdukti);
			temp.clear();

		}

		System.out.println("Postojat " + types.size() + " tipovi na produkti.");
//		System.out.println("Tip i kolku produkti ima od tipot: " + productsFromSameType);

		System.out.println(typeMap);

	}

	public static HashMap<String, List<Product>> sameType(Products products) {
		HashMap<String, List<Product>> typeMap = new HashMap<String, List<Product>>();
		List<List<Product>> typeList = new ArrayList<List<Product>>();
		Set<String> types = new HashSet<String>();
		Integer temp = 0;

		for (Product product : products.getProducts()) {
			types.add(product.getType());
		}
		Iterator<String> i = types.iterator();
		while (i.hasNext()) {
			String s = (String) i.next();
			List<Product> t = new ArrayList<>();
			for (Product product : products.getProducts()) {
				if (s.equals(product.getType()))
					t.add(product);
			}
			typeList.add(t);
			typeMap.put(s, typeList.get(temp));
			temp++;
		}

		return typeMap;
	}

	public static void tipoviNaProdukti(Products list) {
		ArrayList<Product> drinks = new ArrayList<Product>();
		ArrayList<Product> food = new ArrayList<Product>();
		ArrayList<Product> fruits = new ArrayList<Product>();
		ArrayList<Product> packs = new ArrayList<Product>();

		HashMap<String, ArrayList<Product>> typeMap = new HashMap<String, ArrayList<Product>>();

		for (Product product : list.getProducts()) {
			switch (product.getType()) {
			case "drink":
				drinks.add(product);
				break;
			case "food":
				food.add(product);
				break;
			case "fruit":
				fruits.add(product);
				break;
			case "pack":
				packs.add(product);
				break;
			default:
				System.out.println("");
				break;
			}
		}

		for (Product drink : drinks) {
			typeMap.put(drink.getType(), drinks);
		}

		for (Product hrana : food) {
			typeMap.put(hrana.getType(), food);
		}

		for (Product fruit : fruits) {
			typeMap.put(fruit.getType(), fruits);
		}

		for (Product pack : packs) {
			typeMap.put(pack.getType(), packs);
		}

		System.out.println("Produkti od tipot drink imame: " + drinks.size());
		System.out.println("Produkti od tipot food imame: " + food.size());
		System.out.println("Produkti od tipot fruit imame: " + fruits.size());
		System.out.println("Produkti od tipot pack imame: " + packs.size());
		System.out.println("HasMap so tip i lista od tipot: " + typeMap);

	}

	public static void minMax(Products lista) {
		HashMap<String, Double> priceMap = new HashMap<>();

		for (Product product : lista.getProducts()) {
			Integer productPrice = getPriceAsInt(product.getPrice());

			Double quantity = Double.parseDouble(product.getQuantity());

			priceMap.put(product.getId(), productPrice * quantity);
		}

		Set<String> keys = priceMap.keySet();
		Double min = 0.00;
		Double max = 0.00;

		String minKey = "";
		String maxKey = "";
		Boolean flag = true;
		for (String key : keys) {
			if (flag) {
				min = priceMap.get(key);
				minKey = key;
				max = priceMap.get(key);
				maxKey = key;
				flag = false;
			}

			if (min > priceMap.get(key)) {

				min = priceMap.get(key);
				minKey = key;
			}

			if (max < priceMap.get(key)) {
				max = priceMap.get(key);
				maxKey = key;
			}

		}

		for (Product product : lista.getProducts()) {
			if (minKey.equals(product.getId())) {
				System.out.println("Najevtin produkt e: " + product.getName() + ", so cena od " + product.getPrice()
						+ " po " + product.getWeight());
			} else if (maxKey.equals(product.getId())) {
				System.out.println("Najskap produkt e: " + product.getName() + ", so cena od " + product.getPrice()
						+ " po " + product.getWeight());
			}
		}

	}

	private static Integer getPriceAsInt(String priceWithMkd) {

		Integer x = 0;

		if (priceWithMkd.endsWith("MKD")) {

			char[] listFromStrings = priceWithMkd.toCharArray();
			Integer length = listFromStrings.length;

			String value = priceWithMkd.substring(0, length - 3);

			Integer value2 = Integer.parseInt(value);
			x += value2;
		}
		return x;

	}

}
