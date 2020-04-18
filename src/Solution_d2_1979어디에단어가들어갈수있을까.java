
import java.util.Scanner;

public class Solution_d2_1979어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			
			//map 생성
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			
			boolean cntin_one = false;
			int one_count = 0;
			
			int possible = 0;
			
			//가로 검사
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					
					if(map[j][k] == 1 && cntin_one == true) {
						one_count += 1;
					}
					else if(map[j][k] == 1) {
						cntin_one = true;
						one_count = 1;
					}else {
						if(one_count == K) {
							possible += 1;
						}
						one_count = 0;
						cntin_one = false;
					}
				}
				
				
				if(one_count == K) {
					possible += 1;
				}
				

				// one_count 초기화
				one_count = 0;
			}
			
			//세로 검사
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					
					if(map[k][j] == 1 && cntin_one == true) {
						one_count += 1;
					}
					else if(map[k][j] == 1) {
						cntin_one = true;
						one_count = 1;
					}else {
						if(one_count == K) {
							possible += 1;
						}
						one_count = 0;
						cntin_one = false;
					}
				}
				
				
				if(one_count == K) {
					possible += 1;
				}
				
				// one_count 초기화
				one_count = 0;
			}
			
			System.out.printf("#%d %d\n",i,possible);
			
		}
			
	}

}
