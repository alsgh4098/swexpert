package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d5_최적경로 {
	
	static int N;
	
	//현재까지 이동거리.
	static int[] now;
	static boolean[] visited;
	
	static int[] dx; 
	static int[] dy;
	static int[] d;
	
	static int sx;
	static int sy;

	static int fx;
	static int fy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			dx = new int[N];
			dy = new int[N];
			now = new int[N+2];
			visited = new boolean[N];
			d = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//회사 ,그리고 계속 현 위치로 바뀜.
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			//집
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());
			
			//배달
			for (int i = 0; i < N; i++) {
				dx[i] = Integer.parseInt(st.nextToken());
				dy[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int k = 0; k < N; k++) {				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						d[k] += Math.abs(dx[i]-dx[j])+Math.abs(dy[i]-dy[j]);
					}
				}
				System.out.println(d[k]);
			}
			
		}
	}
	
	// 1부터 시작.
	// now[0] = 0, 현위치에서 현위치.
	static void solution(int count) {
		if(count == N+1) {
			return;
		}
		
		int next = calc();
		now[count] = now[count-1]+Math.abs(sx-dx[next])+Math.abs(sy-dy[next]);
		// 더 이상 방문하지 않은곳이 없으면 calc에서 -1리턴됨 
		if(next != -1) {			
			sx = dx[next];
			sy = dy[next];
		}
		
		solution(count+1);
		
	}
	
	
	// 리턴값 : 현재위치에서 가장 가까운 배달장소 인덱스
	static int calc() {
		int min = 201;
		int index = -1;
		
		//제일 가까운곳 찾기.
		for (int i = 0; i < N; i++) {
			if(!visited[i] && Math.abs(sx-dx[i])+Math.abs(sy-dy[i]) < min) {
				min = Math.abs(sx-dx[i])+Math.abs(sy-dy[i]);
				index = i;
			}
		}
		
		//위에서 찾은 제일 가까운곳 방문
		for (int i = 0; i < N; i++) {
			if(i==index) {
				visited[i] = true;
				break;
			}
		}
		
		return index;
	}

}
