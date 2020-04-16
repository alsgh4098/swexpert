package algo0206;

public class arr_map {
	
	static int[][] map;
	static int[] dy = {1,0}; 
	static int[] dx = {0,1}; // 하,우만갈 수 있다.
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 5;
		map = new int[N][N];
		go(0,0);
	}


	private static void go(int y, int x) {
		// d=0이면 하 체크,  d=1이면 우체크
		for (int d = 0; d < 2; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			if( ny>=0 && ny<N && nx>=0 && nx < N) {
				if( d==0) {
					System.out.printf(" (%d,%d) V  ", ny,nx);
					go(ny,nx);
				}else {
					System.out.printf(" (%d,%d) >  ", ny,nx);
					go(ny,nx);
				}
			}
			
		}
		
	}

}
