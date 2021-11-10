package factoryPattern;

public class Test {

	public static void main(String[] args) {
		
		
		Computer pc = new ComputerFactory().getComputer("pc", "2.4", "1TB", "16GB");
		Computer server = new ComputerFactory().getComputer("server", "3.2", "2TB", "32GB");
		
		System.out.println("PC: "+pc.toString());
		
		System.out.println("Srver: "+server.toString());
		

	}

}
