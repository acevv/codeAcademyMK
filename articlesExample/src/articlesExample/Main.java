package articlesExample;




public class Main {

	public static void main(String[] args) {
		
		ArticlesJAXB jaxb = new ArticlesJAXB();

		Articles produkti = new Articles();
		produkti = jaxb.unmarshall();

		for (Article produkt : produkti.getArticles()) {
			System.out.println(produkt);
		}
	}

}
