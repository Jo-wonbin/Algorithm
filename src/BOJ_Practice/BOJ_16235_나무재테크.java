package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static int n, m, k, result;
	static int map[][];
	static int robot[][];
	static Deque<Integer>[][] q;
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		robot = new int[n + 1][n + 1];

		q = new ArrayDeque[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				q[i][j] = new ArrayDeque<Integer>();
			}
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				robot[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			q[x][y].add(size);
		}
		result = 0;
		start();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void start() {
		while (k-- > 0) {
			int dead[][] = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) { // 봄
				for (int j = 1; j <= n; j++) {
					int c = q[i][j].size();
					for (int h = 0; h < c; h++) {
						int tree = q[i][j].poll();
						if (tree <= map[i][j]) {
							q[i][j].addLast(tree + 1);
							map[i][j] -= tree;
						} else {
							dead[i][j] += tree / 2;
						}
					}

				}
			}
			for (int i = 1; i <= n; i++) { // 여름
				for (int j = 1; j <= n; j++) {
					map[i][j] += dead[i][j];
				}
			}

			for (int i = 1; i <= n; i++) { // 가을
				for (int j = 1; j <= n; j++) {
					for (int tree : q[i][j]) {
						if (tree % 5 == 0) {
							for (int z = 0; z < 8; z++) {
								int nx = i + dx[z];
								int ny = j + dy[z];

								if (nx < 1 || ny < 1 || nx > n || ny > n)
									continue;
								q[nx][ny].addFirst(1);
							}
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) { // 겨울
				for (int j = 1; j <= n; j++) {
					map[i][j] += robot[i][j];
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int c = q[i][j].size();
				result += c;
			}
		}
	}
}
