import java.util.*;
import java.math.BigInteger;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID:  10183 - How Many Fibs? 
*
*/

class Main {
	static final int MAX = 501;
    static BigInteger[] fib = new BigInteger[MAX];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger a,b;
		fib[0] = BigInteger.valueOf(0);
		fib[1] = BigInteger.valueOf(1);
		fib[2] = BigInteger.valueOf(2);
		int start, end, count;
		for(int i = 3; i < MAX; ++i)
			fib[i] = fib[i-1].add(fib[i-2]);
		while(true) {
			a = s.nextBigInteger();
			b = s.nextBigInteger();
			if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))
				break;
			else if(a.compareTo(BigInteger.ZERO)==0&&b.compareTo(BigInteger.ZERO)==0)
				System.out.println("1");
			else if(a.compareTo(BigInteger.ZERO)==0&&b.compareTo(BigInteger.ONE)==0)
				System.out.println("1");
			else if(a.compareTo(BigInteger.ONE)==0&&b.compareTo(BigInteger.ONE)==0)
				System.out.println("1");
			else {
				count = 0;
				for(int i=1;i<MAX;i++)
					if(fib[i].compareTo(a)>=0&&fib[i].compareTo(b)<=0)
						++count;
				System.out.println(count);

			}
		}
	}
}