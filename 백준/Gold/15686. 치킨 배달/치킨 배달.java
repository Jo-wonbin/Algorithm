import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static ArrayList<Point> chic = new ArrayList<>();
	static ArrayList<Point> home = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static Point[] temp;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int tp = Integer.parseInt(st.nextToken());
				if (tp == 0)
					continue;

				if (tp == 2)
					chic.add(new Point(i, j));
				else
					home.add(new Point(i, j));
			}
		}
		temp = new Point[M];
		find(0, 0, 0);
		System.out.println(pq.poll());
		br.close();
	}

	static void find(int cnt, int num, int flag) {
		if (cnt == M) {
			int size = home.size();
			int min = 0;
			for (int i = 0; i < size; i++) {
				int sum = Integer.MAX_VALUE;
				Point hm = home.get(i);
				for (int j = 0; j < M; j++) {
					Point ch = temp[j];
					sum = Math.min(Math.abs(hm.x - ch.x) + Math.abs(hm.y - ch.y), sum);
				}
				//각각의 집에서 가장 작은 치킨거리의 합을 저장
				min += sum;
			}
			pq.add(min);
			return;
		}
		int csize = chic.size();
		for (int i = num; i < csize; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			temp[cnt] = chic.get(i);
			find(cnt + 1, i + 1, flag | 1 << i);
		}
	}
}
