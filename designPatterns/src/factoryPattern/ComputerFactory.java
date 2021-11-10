package factoryPattern;

public class ComputerFactory {

	public static Computer getComputer(String type, String cpu, String hdd, String ram) {

		if ("pc".equals(type)) {
			return new PC(cpu, ram, hdd);
		} else if ("server".equals(type)) {
			return new Server(cpu, ram, hdd);
		} else {
			return null;
		}

	}

}
