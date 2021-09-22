package nizi;

public class Account {
	
	// class paramaeters
	Integer a;
	Integer b;

	// constructor with 2 parameters
	public Account(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Account [a=" + a + ", b=" + b + "]";
	}
	
	// metod  to set a and b with parameters from input (c, d)
	public void setData(int c, int d) {
		a = c;
		b = d;
	}
	
	// metod to print object values
	public void showData() {
		System.out.println("Value of a = " + a);
		System.out.println("Value of b = " + b);
	}
	
	// default constructor bez parametri
	public Account() {
		super();
	}
}
