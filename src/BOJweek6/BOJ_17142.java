package BOJweek6;

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

class pair {
	int x, y;

	pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_17142 {

	static int n, m, space;
	static int map[][];
	static ArrayList<pair> al = new ArrayList<>();
	static int dx[] = { -1, 0, 1, 0 }; // 상우하좌
	static int dy[] = { 0, 1, 0, -1 };
	static int copy[][];
	static int check[][];
	static boolean mapchk[];
	static int result = -1;
	static ArrayList<Integer> end = new ArrayList<>();
	static boolean chk = false;

	static void copyMap(int[][] map, int[][] copy) { // 맵 복사
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	static void point(int cnt, int num) throws IOException { // 바이러스 퍼뜨릴 위치 탐색
		if (cnt == m) {
			bfs(space);
			return;
		}

		for (int i = num; i < al.size(); i++) { // 재귀로 탐색
			if (!mapchk[i]) {
				mapchk[i] = true;
				point(cnt + 1, i + 1);
				mapchk[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		copy = new int[n][n];
		check = new int[n][n];

		for (int i = 0; i < n; i++) { // 체크 초기화
			Arrays.fill(check[i], -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					al.add(new pair(i, j));
				}
				if (map[i][j] == 0) {
					space += 1;
				}
			}
		}
		mapchk = new boolean[al.size()];

		point(0, 0);
		if (space == 0) {
			bw.write("0");
		} else
			bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int zz) throws IOException {
		Queue<pair> q = new LinkedList<>();
		copyMap(map, copy);
		zz = space;

		for (int i = 0; i < al.size(); i++) {
			if (mapchk[i]) {
				int x = al.get(i).x;
				int y = al.get(i).y;
				q.add(new pair(x, y));
				check[x][y] = 0;
			} else {
				int x = al.get(i).x;
				int y = al.get(i).y;
				copy[x][y] = 3;
			}
		}

		while (!q.isEmpty()) {
			pair now = q.poll(); // 큐값을 now에 저장하고 삭제

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h]; // 상하좌우 bfs탐색
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (copy[nx][ny] == 1)
					continue;
				if (check[nx][ny] > -1)
					continue;

				if (copy[nx][ny] == 0) {
					zz -= 1;
				}

				check[nx][ny] = check[now.x][now.y] + 1;
				copy[nx][ny] = 2;
				q.offer(new pair(nx, ny));

				if (zz == 0) {
					if (result < 0) {
						result = check[nx][ny];
					} else {
						result = Math.min(result,  check[nx][ny]);
					}
					break;
				}
			}

		}

//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(copy[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------------");
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(check[i][j] + " ");
//
//			}
//
//			System.out.println();
//		}
//		System.out.println("----------------");
//
//		int c = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if(copy[i][j] == 0) {
//					c+=1;
//				}
//			}
//		}

//		if (c == 0) { // copy에 0이 없을 경우 최대값 계산
//			chk = true;
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					result = Math.max(result, check[i][j]);
//				}
//			}
//			end.add(result);
//		}

		for (int i = 0; i < n; i++) { // 체크 초기화, resuㅣt 초기화
			Arrays.fill(check[i], -1);
		}
	}
}
