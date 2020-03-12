import java.util.Arrays;
import java.util.Scanner;

public class R08_DiceTest {
	
	static int N,M, number[];
	static boolean selected[];
	static int totalCnt;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		number = new int[N];
		selected = new boolean[7];
		totalCnt = 0;
		
		switch(M) {
			// 중복순열
			case 1:
				dice1(0);
				System.out.println("총 : "+ totalCnt);
				break;
			// 순열
			case 2:
				dice2(0);
				System.out.println("총 : "+ totalCnt);
				break;
			// 조합
			case 3:
				dice3(0,1);
				System.out.println("총 : "+ totalCnt);
				break;
			// 중복조합
			case 4:
				dice4(0,1);
				System.out.println("총 : "+ totalCnt);
				break;
		}
	}
	
	// 중복순열
	public static void dice1(int cnt){
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			number[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	// 순열
	public static void dice2(int cnt){
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			if(!selected[i]) {
				selected[i] = true;
				number[cnt] = i;				
				dice2(cnt+1);
				selected[i] = false;
			}
		}
	}
	
	// 중복 조합
	public static void dice3(int cnt, int cur){
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = cur; i <= 6; i++) {
			number[cnt] = i;
			dice3(cnt+1,i);
		}
	}
	
	// 조합
	public static void dice4(int cnt, int cur){
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = cur; i <= 6; i++) {
			number[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}

}
