package practicePrograms;

import javax.swing.JOptionPane;

public class Matematika {

	public static void main(String[] args) {

		double z;
//		Scanner scan = new Scanner(System.in);

		JOptionPane.showMessageDialog(null, "This program will calculate the hypotenuse of a triangle.");

		double x = Double.parseDouble(JOptionPane.showInputDialog("Enter side x:"));
		double y = Double.parseDouble(JOptionPane.showInputDialog("Enter side y:"));

//		System.out.println("Enter side x:");
//		x = scan.nextDouble();

//		System.out.println("Enter side y:");
//		y = scan.nextDouble();

		z = Math.sqrt((x * x) + (y * y));
		JOptionPane.showMessageDialog(null,
				"A triangle with a side x: " + x + " and a side y: " + y + ", has a hypotenuse of: " + z);
//		System.out.println("The hypotenuse is: "+z);
//		scan.close();

	}

}
