
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_d2_2005_파스칼의삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] line1 = new int[]{1};
			int[] line2 = new int[]{1,1};
			
			int[][] pas_tri = new int[N][];
			
			pas_tri[0] = line1;
			
			if(N>1) {
				pas_tri[1] = line2;				
			}
			
			for (int i = 2; i < N; i++) {
				int[] new_line = new int[i+1];
				new_line[0] = 1;
				new_line[new_line.length-1] = 1;
				for (int j = 1; j < new_line.length-1; j++) {
					new_line[j] = pas_tri[i-1][j] + pas_tri[i-1][j-1];
				}
//				System.out.println(Arrays.toString(new_line));
				pas_tri[i] = new_line;
			}
			
			System.out.printf("#%d\n",t);
			for (int i = 0; i < pas_tri.length; i++) {
				for (int j = 0; j < pas_tri[i].length; j++) {
//					System.out.println(i);
					System.out.printf("%d ",pas_tri[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}

}
