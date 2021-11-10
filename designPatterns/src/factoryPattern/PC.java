package factoryPattern;

public class PC extends Computer {

	private String cpu;
	private String ram;
	private String hdd;

	@Override
	public String getHDD() {

		return this.hdd;
	}

	@Override
	public String getCPU() {

		return this.cpu;
	}

	@Override
	public String getRAM() {

		return this.ram;
	}

	public PC(String cpu, String ram, String hdd) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
}
