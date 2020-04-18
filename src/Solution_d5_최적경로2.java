import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_최적경로2 {
	static int N;
	
	
	static int[] dx; 
	static int[] dy;
	static int[] select;
	
	static int sx;
	static int sy;

	static int fx;
	static int fy;
	
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			dx = new int[N];
			dy = new int[N];
			select = new int[N];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//회사 ,그리고 계속 현 위치로 바뀜.
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			//집
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());
			// 배달 방문
			for (int i = 0; i < N; i++) {
				dx[i] = Integer.parseInt(st.nextToken());
				dy[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(0,0);
			
			System.out.println("#"+t+" "+min);
		}
	}
	
	static void solution() {
			int x = sx;
			int y = sy;
			int x2 = fx;
			int y2 = fy;
			
			int move = 0;
			
			for (int i = 0; i < N; i++) {
				move += Math.abs(x-dx[select[i]]) + Math.abs(y-dy[select[i]]);
				x = dx[select[i]];
				y = dy[select[i]];
			}
			
			move += Math.abs(x-x2) + Math.abs(y-y2);
			
			if(move < min) {
				min = move;
			}
			return;
	}
	
	public static void perm(int flag, int count) {
		if (N == count) {
			solution();
		} else {
			for (int i = 0; i < N; i++) {
				if ((flag & (1 << i)) != 0) {
					continue;
				} else {
					select[count] = i;
					perm(flag | (1 << i), count + 1);
				}
			}
		}
	}

}
