package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_종구의딸이름짓기2 {

	static int N;
	static int M;

	static char[][] map;
	static boolean[][] visited;
	// 오른, 아래
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	static String res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			res = "";
			
			PriorityQueue<Point> q = new PriorityQueue<Point>();
			q.offer(new Point(0, 0, "" + map[0][0]));
			visited[0][0] = true;

			while (!q.isEmpty()) {
				Point poll=q.poll();
	            int y=poll.y;
	            int x=poll.x;
	            String s=poll.str;
	            
	            if(x==N-1&&y==M-1) {
	            	res = s;
	            	break;
	            }
	            for(int i=0;i<2;i++) {
	                int ny=y+dy[i];
	                int nx=x+dx[i];
	                if(inner(nx,ny)&&!visited[nx][ny]) {
	                    visited[nx][ny]=true;
	                    q.add(new Point(nx,ny,s+map[nx][ny]));
	                }
	            }
			}
			System.out.println("#" + t + " " + res);
			q.clear();
		}
	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		String str;

		public Point(int x, int y, String string) {
			super();
			this.x = x;
			this.y = y;
			this.str = string;
		}

		@Override
		public int compareTo(Point o) {
			return this.str.compareTo(o.str);
		}
	}
	

	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		} else {
			return false;
		}
	}

}
