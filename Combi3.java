package ssafyalgo0129;

public class Combi3 {

	static int N = 6;
	static int R = 3;
	static char[] cc;
	static boolean[] isGo;

	public static void main(String[] args) {
		cc = new char[N];
		isGo = new boolean[N];
		cc = "ABCDEF".toCharArray();
		combi(0, 0);
	}

	public static void combi(int start, int count) {
		if (count == R) {
			String a = "";
			String b = "";
			for (int i = 0; i < cc.length; i++) {
				if (isGo[i]) {
					a = a + cc[i];
				} else {
					b = b + cc[i];
				}
			}
			System.out.println(a);
			System.out.println(b);
			return;
		}
		for (int i = start; i < N; i++) {
			if (!isGo[i]) {
				isGo[i] = true;
				combi(i + 1, count + 1);
				isGo[i] = false;
			}

		}
	}
}
