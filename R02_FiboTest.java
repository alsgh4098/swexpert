import java.util.Scanner;

public class R02_FiboTest {
	
	static long[] call1,call2,memoi;

	static long totalCnt1,totalCnt2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memoi = new long[N+1];
		call1= new long[N+1];
		call2 = new long[N+1];
		
		System.out.println(fibo(N) + " " + call1[N] + " " + totalCnt1);
		System.out.println(fibo2(N) + " " + call2[N] + " " + totalCnt2);
	}
	
	static long fibo(int n) {
		++call1[n];
		++totalCnt1;
		if(n<=1) return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	static long fibo2(int n) {
		++call2[n];
		++totalCnt2;

		if(n<=1) return n;
		
		if(memoi[n] != 0) {
			return memoi[n];
 		}
		
		return memoi[n] = fibo2(n-1) + fibo2(n-2);
	}

}
