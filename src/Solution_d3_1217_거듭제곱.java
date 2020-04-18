import java.util.Scanner;

public class Solution_d3_1217_거듭제곱 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int TC = sc.nextInt();
			
			int x = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.printf("#%d %d\n",TC,pow(x,n));
		}
	}
	
	static int pow(int x, int n) {
		if(n == 1) {
			return x;
		}else {
			return pow(x,n-1)*x;
		}
	}

}
