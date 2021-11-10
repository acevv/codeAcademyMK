package factoryPattern;

public abstract class Computer {
	
	public abstract String getHDD();
	public abstract String getCPU();
	public abstract String getRAM();
	@Override
	public String toString() {
		return "Computer [getHDD()=" + getHDD() + ", getCPU()=" + getCPU() + ", getRAM()=" + getRAM() + "]";
	}
	
	

}
