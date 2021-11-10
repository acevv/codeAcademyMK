package abstractFactoryPattern;

public class PCFactory implements AbstractComputerFactory {
	

	private String cpu;
	private String ram;
	private String hdd;

	public PCFactory(String cpu, String ram, String hdd) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}

	@Override
	public Computer createComputer() {
		
		return new PC(cpu, ram, hdd);
	}

}
