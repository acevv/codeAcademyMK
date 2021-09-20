package nizi;

public class Matrix {

	// Example: a[4][4] => a [4x4]

//	        0        1          2            3
//	0.   a[0][0]   a[0][1]   a[0][2]      a[0][3]
//	1.   a[1][0]   a[1][1]   a[1][2]      a[1][3]
//	2.   a[2][0]   a[2][1]   a[2][2]      a[2][3]
//	3.   a[3][0]   a[3][1]   a[3][2]      a[3][3]
	public static void main(String[] args) {

		Integer matrica[][] = new Integer[4][4];

		matrica[0][0] = 1;
		matrica[0][1] = 2;
		matrica[0][2] = 3;
		matrica[0][3] = 4;

		matrica[1][0] = 5;
		matrica[1][1] = 6;
		matrica[1][2] = 7;
		matrica[1][3] = 8;

		matrica[2][0] = 5;
		matrica[2][1] = 6;
		matrica[2][2] = 7;
		matrica[2][3] = 8;

		matrica[3][0] = 5;
		matrica[3][1] = 6;
		matrica[3][2] = 7;
		matrica[3][3] = 8;

		System.out.println(matrica[3][3]);

	}

}
