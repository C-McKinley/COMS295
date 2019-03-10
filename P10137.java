import java.util.*;
/**
* @author Colby McKinley
* @UVa_ID colby_mckinley
* @JUDGE_ID: 922619
* @Problem_ID: 10137 - The Trip
*
*/
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double arr[];
		while(true) {
			int size = scanner.nextInt();
			if(size == 0)
				break;
			
			arr = new double[size];
			double avg  = 0.0;
			for(int i = 0; i < size; i++) {
				arr[i] = scanner.nextDouble();
				avg  += arr[i];
			}
			avg  = avg/(double)size;
			double pos = 0, neg = 0;
			for(int i = 0; i < size; i++) {
				double diff = (long) ((arr[i] - avg) * 100.0) / 100.0;
				if(diff > 0)
					pos += diff;
				else
					neg -= diff;
			}
			System.out.printf("$%.2f\n", (neg > pos) ? neg : pos);			
		}
	}
}
	