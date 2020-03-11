import java.util.Arrays;
import java.util.Scanner;

public class R06_NextPermutation {
	
	static int N;
	static int[] input;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		// 시작 : 가장 작은 순열
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		}while(nextPermutation());
		System.out.println("총 : "+totalCnt);
	}// end main
	
	private static boolean nextPermutation() {
		totalCnt++;
		// step 1 꼭대기 오르기, 거꾸로 꼭대기를 올랐을 때, 작아지는 숫자 찾기.
		int i = N-1;
		while(i>0 && input[i-1]>=input[i])i--;
		if(i==0) return false;
			
		// step2
		int j = N-1; // 위에서 찾은 그 숫자보다 같거나 작은 숫자 찾기.
		while(input[i-1]>=input[j]) --j;
		
		// step3 // 위에서 찾은 그 두 숫자의 위치 바꾸기.
		int temp = input[i-1];
		input[i-1] = input[j];
		input[j] = temp;
		
		// step4 내려가기 왼쪽기준 아래는 냅두고 오른쪽 오름차순으로 정렬하기.
		int k = N-1;
		while(i<k) {
			temp = input[i];
			input[i] = input[k];
			input[k] = temp;
			++i;
			--k;
		}
		
		return true;
	}

}
