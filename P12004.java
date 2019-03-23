import java.util.*;
import java.math.*;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID: 12004 - Bubble Sort
*
*/
class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numCases = s.nextInt();
		String input;
		BigInteger answer;
		final BigInteger TWO = new BigInteger("2");
		for(int i = 1; i <= numCases; i++) {
			System.out.printf("Case %d: ", i);
			input = s.next();
			answer = new BigInteger(input);
			answer = answer.multiply(answer.subtract(BigInteger.ONE));
			answer = answer.divide(TWO);
			if(answer.mod(TWO).equals(BigInteger.ZERO))
				System.out.printf("%d\n", answer.divide(TWO));
			else
				System.out.printf("%d/2\n", answer);
		}
		s.close();
	}
}