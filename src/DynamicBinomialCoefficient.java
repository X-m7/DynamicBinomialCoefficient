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
	
	public static long c(int n, int k) {
		if (n == 0) {
			return 0L;
		}
		long[] factorialResults = new long[n + 1];
		factorialResults[0] = 1; //0! = 1
		for (int counter = 1; counter <= n; counter++) { //calculate n! and all before
			factorialResults[counter] = counter * factorialResults[counter - 1];
		}
		return factorialResults[n] / (factorialResults[k] * factorialResults[n - k]);
	}

}
