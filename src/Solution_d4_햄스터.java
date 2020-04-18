import java.io.*;
import java.util.*;

public class Solution_d4_햄스터 {
	static class Pair implements Comparable<Pair> {
		int key, val;
		public Pair(int key, int val) {
			this.key = key;
			this.val = val;
		}
		@Override
		public int compareTo(Pair p) {
			return Integer.compare(p.val, this.val);
		}
	}
	static class Record {
		int left, right, count;
		public Record(int left, int right, int count) {
			this.left = left;
			this.right = right;
			this.count = count;
		}
	}
	static int N, X, M;
	static int[] ans;
	static Pair[] cnt;
	static Record[] records;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(1024);
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = new int[N];
			cnt = new Pair[N];
			records = new Record[M];
			for(int i=0; i<N; i++) {
				cnt[i] = new Pair(i, 0);
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken()) - 1;
				int right = Integer.parseInt(st.nextToken()) - 1;
				int count = Integer.parseInt(st.nextToken());
				records[i] = new Record(left, right, count);
				for(int j=left; j<=right; j++) {
					cnt[j].val++;
				}
			}
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i].val == 0) ans[i] = X;
			}
			
			Arrays.sort(cnt);
			
			sb.append("#").append(tc).append(" ");
			if(dfs(0)) {
				for(int n: ans) sb.append(n).append(" ");
				sb.append("\n");
			} else {
				sb.append(-1).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static boolean dfs(int i) {
		if(i == N || cnt[i].val == 0) return same();
		
		for(int val=0; val<=X; val++) {
			ans[cnt[i].key] = val;
			if(dfs(i+1)) return true;
		}
		ans[cnt[i].key] = 0;
		return false;
	}
	
	public static boolean same() {
		for(Record r: records) {
			int sum = 0;
			for(int i=r.left; i<=r.right; i++) {
				sum += ans[i];
			}
			if(sum != r.count) return false;
		}
		return true;
	}
}