import java.util.Scanner;

public class DynamicBinomialCoefficient {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		String inputN = input.next();
		String inputK = input.next();
		try {
			int n = Integer.parseInt(inputN);
			int k = Integer.parseInt(inputK);
			if (n < 0) {
				throw new NumberFormatException();
			}
			System.out.println(c(n, k));
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} finally {
			input.close();
		}
	}
	
	/*
	 * C(n,k) = C(n-1, k-1) + C(n-1, k)
	 */
	public static long c(int n, int k) {
		long[][] array = new long[n+1][k+1];
		array[0][0] = 1;
		for (int counter = 1; counter <= k; counter++) { //initialize 1st row (c(0,x) for x > 0 is 0)
			array[0][counter] = 0;
		}
		for (int counter = 1; counter <= n; counter++) { //initialize 1st column (c(x,0) for x > 0 is 1)
			array[counter][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) { //initialize 1st row (c(0,x) for x > 0 is 0)
				array[i][j] = array[i-1][j-1] + array[i-1][j];
			}
		}
		return array[n][k];
	}

}
