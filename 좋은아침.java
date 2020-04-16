import java.util.Arrays;

/**
 * @author 진민호
 *
 */
public class 좋은아침 {
	
	static char[] chars = {'a', 'b', 'c', 'd'};

	public static void main(String[] args) {
		
		// chars로 만들 수 있는 부분집합
		int r = 3;
		// chars에서 3개를 고르는 순열을 작성
		makePermutatino(r, new char[r], new boolean[chars.length]);
		// chars에서 3개를 고르는 조합을 작성
		
	}
	
	// chars배열의 4개 문자중에 3개(r)를 뽑음.
	static void makePermutatino(int r, char[] temp,boolean[] visited) {
		//base rule
		if(r==0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}
		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[r-1] = chars[i];
				makePermutatino(r-1, temp, visited);
				visited[i] = false;
			}
		}
		
	} 
	
	// visited를 cloned로 만들어서 사용.
	static void makePermutatino2(int r, char[] temp,boolean[] visited) {
		//base rule
		if(r==0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}
		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			boolean[] cloned = visited.clone();
			if(!cloned[i]) {
				cloned[i] = true;
				temp[r-1] = chars[i];
				makePermutatino(r-1, temp, cloned);
			}
		}
		
	} 

}
