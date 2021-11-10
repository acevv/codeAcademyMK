package abstractFactoryPattern;

public class ComputerFactory {

	public static Computer getComputer(AbstractComputerFactory factory) {
		return factory.createComputer();
	}

}
