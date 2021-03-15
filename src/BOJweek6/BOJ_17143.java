package BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class shark {
	int x, y, s, d, z;

	shark(int x, int y, int s, int d, int z) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

public class BOJ_17143 {

	static int n, m, l, result = 0;
	static int map[][];
	static int copy[][];
	static int check[][];
	static ArrayList<shark> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = z;
			al.add(new shark(r, c, s, d, z));
		}

		for (int i = 1; i <= m; i++) {
			fishing(i);

			move();

//			for (int f = 1; f <= n; f++) {
//				for (int h = 1; h <= m; h++) {
//					System.out.print(map[f][h] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------move----------");
		}
		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void move() {
		check = new int[n + 1][m + 1];
		copy = new int[n + 1][m + 1];
		int c = al.size();
//		System.out.println(c);
		for (int i = 0; i < c; i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			int s = al.get(i).s;
			int d = al.get(i).d;
			int z = al.get(i).z;

			shark now = al.get(i);

			if (d == 1 || d == 2) {
				now.s %= (n * 2) - 2;
				while (now.s > 0) {
					if (now.x == 1) {
						d = 2;
					}
					if (now.x == n) {
						d = 1;
					}
					if (d == 1)
						now.x -= 1;
					else {
						now.x += 1;
					}
					now.s--;
				}
			} else {
				now.s %= (m * 2) - 2;
				while (now.s > 0) {
					if (now.y == 1) {
						d = 3;
					}
					if (now.y == m) {
						d = 4;
					}
					if (d == 3)
						now.y += 1;
					else {
						now.y -= 1;
					}
					now.s--;
				}
			}

			map[x][y] = 0;
			copy[now.x][now.y] = Math.max(copy[now.x][now.y], z);
			check[now.x][now.y]++;
			al.add(new shark(now.x, now.y, s, d, z));

		}
		arg(c);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

	static void arg(int c) {
		for (int i = 0; i < c; i++) {
			al.remove(0);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (check[i][j] > 1) {
					int tmp = check[i][j];
					while (tmp > 0) {
						for (int h = 0; h < al.size(); h++) {
							if (i == al.get(h).x && j == al.get(h).y) {
								if (al.get(h).z < copy[i][j]) {
									al.remove(h);
									break;
								}
							}
						}
						tmp--;
					}
				}
			}
		}
	}

	static void fishing(int y) {
		int c = al.size();
		int i = 1;
		while (i <= n) {

			if (map[i][y] != 0) {
				result += map[i][y];
				for (int h = 0; h < c; h++) {
					if (i == al.get(h).x && y == al.get(h).y) {
						al.remove(h);
						break;
					}
				}
				map[i][y] = 0;
				break;
			}
			i++;
		}
	}
}
