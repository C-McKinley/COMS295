import java.util.*;
import java.math.*;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID: 10213 - How Many Pieces of Land ?
*
*/
class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long numCases = s.nextLong();
		int input;
		
		for(long i = 0; i < numCases; i++) {
			input = s.nextInt();
			System.out.println(solve(input).toString());
		}
		
	}
	
	static BigInteger solve(int n) {
		BigInteger temp=BigInteger.valueOf(n);
        temp=(temp.pow(4)).subtract((temp.pow(3)).multiply(BigInteger.valueOf(6))).add((temp.pow(2)).multiply(BigInteger.valueOf(23))).subtract(temp.multiply(BigInteger.valueOf(18))).add(BigInteger.valueOf(24));
        return temp.divide(BigInteger.valueOf(24));
		
	}

}