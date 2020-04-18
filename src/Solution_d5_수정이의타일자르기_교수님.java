
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_d5_수정이의타일자르기_교수님{
	
	static int N;
	static int M;
	
	static class Rectangle implements Comparable<Rectangle>{
		int max;
		int min;
		
		public Rectangle(int w, int h) {
			super();
			if(w<h) {
				max = h;
				min = w;
			}else {				
				max = w;
				min = h;
			}
		}

		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
	}
	
	static PriorityQueue<Rectangle> left;
	
	static int[] tiles;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			tiles = new int[N];
			left = new PriorityQueue<Rectangle>();
			
			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				tiles[i] = 1<<n;
			}
			
			Arrays.sort(tiles);
			
			left.add(new Rectangle(M,M));
			
			res = 1;
			
			for (int i = N-1; i >= 0; i--) {
				go(tiles[i]);
			}
			
			System.out.println("#"+t+" "+res);
		}

	}//end main
	
	static void go(int size) {
		Rectangle lft = left.poll();
		
		if(size <= lft.min) {
			left.offer(new Rectangle(lft.min-size, size));
			left.offer(new Rectangle(lft.min, lft.max - size));
		}else {
			left.offer(lft);
			left.offer(new Rectangle(M-size,size));
			left.offer(new Rectangle(M,M-size) );
			res++;
		}
	}

}
