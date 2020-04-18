
import java.util.Scanner;

public class Solution_d2_2005_파스칼삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int N = sc.nextInt();
			
			int[][] ps_arr = new int[N][];
			
			ps_arr[0] = new int[1];
			if(N >1) {
				ps_arr[1] = new int[2];
				ps_arr[1][0] = 1;
				ps_arr[1][1] = 1;
			}
			
			ps_arr[0][0] = 1;
			
			int m = 3;

			
		
			while(m <= N) {
							ps_arr[m-1] = new int[m];
			ps_arr[m-1][0] = 1;
			ps_arr[m-1][m-1] = 1;
				for(int k = 1; k<m-1; k++) {
					ps_arr[m-1][k] = ps_arr[m-2][k-1] + ps_arr[m-2][k]; 
				}
				
				m++;
			}
			
			System.out.printf("#%d\n",i);
			for(int x=0; x<N; x++) {
				for(int y=0; y<ps_arr[x].length; y++) {
						System.out.printf("%d ",ps_arr[x][y]);
				}
				System.out.println();
			}
			
		}

	}

}