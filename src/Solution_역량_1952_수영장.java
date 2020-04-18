import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_1952_수영장 {
	
	static int[] month;
	static int[] price;
	static int[] ticket;
	static int min;

 	public static void main(String[] args) throws NumberFormatException, IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		
 		int TC = Integer.parseInt(br.readLine());
 		
 		for (int t = 1; t <= TC; t++) {
 			min = Integer.MAX_VALUE;
 			// 1~12사용.
 			month = new int[13];
 			// 월별로 산 티켓 종류.
 			ticket = new int[13];
 			// 가격표
 			price = new int[4];
 			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			// end input
			
			dfs(1);
			
			//1년요금과 비교.
			min = Math.min(min, price[3]);
			
			System.out.println("#"+t+" "+min);
			
			
		}
	}// end main
 	
 	// 수영장을 가는 해당 월, 티켓의  경우의 수.
 	// price[0 ,1 ,2] 각각 일일, 한달, 세달, 1년은 main에서 비교.
 	static void dfs(int mnth) {
 		// 1~12월
 		if(mnth > 12) {
 			int sum = 0;
 			for (int i = 1; i <= 12; i++) {
				sum += ticket[i];
			}
 			
 			if(sum < min) {
 				min = sum;
 			}
 			return;
 		}
 		
 		// 수영장을 안 갈 경우.
 		if(month[mnth] == 0) {
 			dfs(mnth+1);
 			return;
 		}
 		ticket[mnth] = month[mnth] * price[0];
 		dfs(mnth+1);
 		ticket[mnth] = price[1];
 		dfs(mnth+1);
 		// mnth 뒤에 초기화가 덜된다.
 		// 내가 생각한 재귀 방식이 틀리지는 않았다.
 		// 그 전 재귀함수에서 저장된 값이 남아있는게 문제였다.
 		ticket[mnth] = price[2];
 		if(mnth+1<13) {
 			ticket[mnth+1] = 0; 			
 		}
 		if(mnth+2<13) {
 		ticket[mnth+2] = 0;
 		}
 		dfs(mnth+3);
 	}

}
