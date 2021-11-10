package abstractFactoryPattern;

public class Test {

	public static void main(String[] args) {

		AbstractComputerFactory factory = new PCFactory("2.4", "1tb", "12gb");
		PC pc = (PC) new ComputerFactory().getComputer(factory);

		AbstractComputerFactory severFactory = new ServerFactory("3.2", "48", "2gb");
		Server server = (Server) new ComputerFactory().getComputer(severFactory);
		
		System.out.println(pc);
		System.out.println(server);

	}

}
