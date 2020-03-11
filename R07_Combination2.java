import java.util.Arrays;
import java.util.Scanner;

public class R07_Combination2 {
	
	static int N,R;
	static int[] input,number;
	static int totalCnt;
	
//	nCr = n-1Cr + n-1Cr-1
//	을 이용해서 짜는 코드.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		number = new int[R];
		
		
		// N개의 숫자중에 R개를 뽑아 만들 수 있는 경우의 수
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(N,R);
		System.out.println("총 경우의 수"+totalCnt);
	}
	
	// 현재위치에 조합할 수 선택
	// n번째 원소를 r위치에 조합해보기.
	private static void combination(int n, int r) {
		
		if(r==0) {
			++totalCnt;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		if(n<r) return;
		// 선택
		number[r-1] = input[n-1];
		combination(n-1, r-1);
		// 비선택
		combination(n-1, r);
	}

}
