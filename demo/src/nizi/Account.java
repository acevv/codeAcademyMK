package nizi;

public class Account {
	int a;
	int b;
//	int c;
	public void setData(int c, int d) {
		a=c;
		b=d;
	}
	
	public void showData() {
		System.out.println("Value of a = " + a);
		System.out.println("Value of b = " + b);
	}
}
