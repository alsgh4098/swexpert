
import java.util.Scanner;

public class Solution_d3_6730_장애물경주난이도 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		int[] blocks;
		
		for (int t = 1; t <= TC; t++) {
		
			int n = sc.nextInt();
			
			blocks = new int[n];
			
			for (int i = 0; i < blocks.length; i++) {
				blocks[i] = sc.nextInt();
			}
			
			int mx_max = 0;
			
			int min_max = 0;
			
			for (int i = 0; i < blocks.length-1; i++) {
				if(blocks[i] < blocks[i+1]) {
					if(blocks[i+1] - blocks[i] > mx_max) {
						mx_max = blocks[i+1] - blocks[i];
					}
				}
				
				if(blocks[i] > blocks[i+1]) {
					if(blocks[i] - blocks[i+1] > min_max) {
						min_max = blocks[i] - blocks[i+1];
					}
				}
			}
			
			System.out.printf("#%d %d %d\n",t,mx_max,min_max);
			
		}

	}

}
