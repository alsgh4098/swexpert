import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_4111_무선단속카메라 {

	static int[] camera;

	static int camera_cnt;

	static int receiving_set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			camera_cnt = Integer.parseInt(br.readLine());

			camera = new int[camera_cnt];

			receiving_set = Integer.parseInt(br.readLine());
			
			int max = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < camera_cnt; i++) {
				camera[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(camera);

			int[] interval = new int[camera_cnt - 1];

			for (int i = 0; i < camera.length - 1; i++) {
				interval[i] = camera[i + 1] - camera[i];
			}

			Arrays.sort(interval);

			int res = 0;

			if (camera_cnt <= receiving_set) {
				res = 0;
			} else {

				for (int i = 0; i < interval.length - (receiving_set - 1); i++) {
					res += interval[i];
				}
			}
			
			System.out.printf("#%d %d\n",t,res);

		}

	}

}
