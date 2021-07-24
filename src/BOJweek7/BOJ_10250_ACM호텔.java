package BOJweek7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250_ACM호텔 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		String a = br.readLine();
		int num = Integer.parseInt(a);

		while (num-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int floor = ((N - 1) % H) + 1;// 층수
			int roomNum = ((N - 1) / H)+1;// 번호

			if (roomNum < 10) {
				System.out.printf("%d0%d\n", floor, roomNum);
			} else {
				System.out.printf("%d%d\n", floor, roomNum);
			}

		}

		br.close();
	}

}
