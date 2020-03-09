import java.util.Scanner;

public class R03_HanoiTest {
	
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		hanoi(N,1,2,3);
		
		System.out.println(result.toString());
	}
	
	static void hanoi(int cnt, int from, int temp, int to) {
					  // 원판갯수(맨아래 원판 번호), 시작기둥, 임시기둥, 목적기둥
		if(cnt==0) {
			return;
		}
		// 시작기둥의 n-1 덩어리 원판을 임시기둥으로 옮김.
		hanoi(cnt-1,from,to,temp);
		result.append(cnt+" : "+from+"->"+to+"\n");
		// n원판을 목적기둥으로 옮김
		hanoi(cnt-1,temp,from,to);
		
		//
	}

}
