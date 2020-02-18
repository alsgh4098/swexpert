

import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int N = sc.nextInt();
			
			int[][] snail = new int[N][N];
			
			int  x = 0;
			int  y = 0;
			int len = N;
			int number = 1;
			char dir = 's';

			// r 4 2
			// d 3 1
			// l 3 1
			// u 2 
			
			//0123

			while( len != 0){
				
//					System.out.println("len : " + len);

					if( dir == 's') {
						for(int dy=0; dy<len; dy++) {
//							System.out.println(x +" " +(y+dy));
							snail[x][y+dy] = number;
							number++;
						}
						y = y+len-1;
						len -=1;
						dir = 'd';
					}else if( dir == 'd') {
						for(int dx=1; dx<=len; dx++) {
//							System.out.println(dx+x +" " +y);
							snail[x+dx][y] = number;
							number++;
						}
						x = x+len;
						dir = 'l';
					}else if( dir == 'l') {
						for(int dy=1; dy<=len; dy++) {
//							System.out.println(x +" " +(y-dy));
							snail[x][y-dy] = number;
							number++;
						}
						y = y-len;
						dir = 'u';
						len -= 1;
					}else if( dir == 'u') {
						for(int dx=1;  dx<=len; dx++) {
//							System.out.println(dx +" " +y);
							snail[x-dx][y] = number;
							number++;
						}
						x = x-len;
						dir = 'r';
					}else if( dir == 'r') {
						for(int dy=1; dy<=len; dy++) {
//							System.out.println(x +" " +dy);
							snail[x][y+dy] = number;
							number++;
						}
						y = y+len;
						dir = 'd';
						len -=1;
					}
				
			}
			
			System.out.println("# "+i);
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					System.out.printf("%d ",snail[j][k]);
				}
				System.out.println();
			}
		}
	}
}


