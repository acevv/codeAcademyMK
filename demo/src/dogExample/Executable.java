package dogExample;

public class Executable {

	public static void main(String[] args) {
		
		Dog retriever = new Dog();
		retriever.breed = "Golden Retriever";
		retriever.age = 8;
		retriever.color = "Golden";
		retriever.size = "Big";
		System.out.println(retriever.getInfo());

	}

}
