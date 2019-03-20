import java.util.*;

/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID: 10276 - Hanoi Tower Troubles Again!
*
*/
class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numCases = s.nextInt();
		for(int i = 0; i < numCases; i++)
			System.out.println(value(s.nextInt()));
		s.close();
	}
	
	static int value(int n) {
		return (int)(Math.pow(n + 1, 2)/2) -1;
	}
}