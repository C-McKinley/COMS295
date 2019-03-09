import java.util.Scanner;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID:  100 - The 3n + 1 problem 
*
*/
class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int i,j, counter, cycleLength = 0, n, temp;
		while(s.hasNextInt()) {
			i = s.nextInt();
			j = s.nextInt();
			System.out.print(i + " " + j + " ");
			cycleLength = 0;
			counter = 0;
			if(i>j) {
				temp = j;
				j = i;
				i = temp;
			}
			while(i <= j) {
				n = i;
				counter = 1;
				while(n != 1) {
					if(n%2==0)
						n/=2;
					else
						n = 3*n +1;
					counter++;
				}
				if(counter > cycleLength)
					cycleLength = counter;
				i++;
			}
			System.out.println(cycleLength);
		}
	}
}