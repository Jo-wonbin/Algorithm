package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
	int x;
	int y;

	location(int x, int cnt) {
		this.x = x;
		this.y = cnt;
	}
}

public class BOJ_2108 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Queue<location> q = new LinkedList<location>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		int max = -4001;
		int min = 4001;
		int sum = 0;
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st1.nextToken());
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			sum = sum + arr[i];
		}

		Arrays.sort(arr); // 오름차순 정렬
		int temp = 0;
		int cnt = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] == arr[i]) { // 중복된 것이 있으면 cnt +1
				cnt += 1;
				int tp = arr[i];
				q.add(new location(tp, cnt));

			} else {
				cnt = 1;
			}

			temp = Math.max(temp, cnt);

		}

		bw.write(Math.round((double) sum / n) + "\n");
		bw.write(arr[n / 2] + "\n");

		if (q.isEmpty()) { // 최빈값이 없을 경우 두 번째 작은 값 출력
			for (int i = 0; i < arr.length; i++) {
				if (1 == arr.length) {
					bw.write(arr[0] + "\n");
					break;
				} else if (i > 0 && arr[i] > arr[i - 1]) {
					bw.write(arr[i] + "\n");
					break;
				}
			}

		} else { // 최빈값이 있는 경우
			while (!q.isEmpty()) {
				location now = q.poll();

				if (now.y == temp) {
					al.add(now.x);

				}
			}
			if (al.size() == 1)
				bw.write(al.get(0) + "\n");
			else if (al.size() > 1)
				bw.write(al.get(1) + "\n");

		}

		bw.write(max - min + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

}
