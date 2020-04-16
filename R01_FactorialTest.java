import java.util.Scanner;

public class R01_FactorialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
	}
	
	// n! : n * (n-1)!
	// n! 계산
	
	static long factorial(long n) {
		// 기저파트(째귀종료)
		if(n==1) {
			return 1;
		}
		// 유도(파생)파트
		return n*factorial(n-1);
	}

}
