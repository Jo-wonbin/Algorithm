package BOJ.BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class puyo {
	int x, y, color;

	puyo(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class BOJ_11559 {
	static int map[][];
	static int check[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };
	static boolean chk;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[12][6];

		for (int i = 0; i < 12; i++) {
			String a = br.readLine();
			for (int j = 0; j < 6; j++) {
				if (a.substring(j, j + 1).equals(".")) {
					map[i][j] = 0;
				} else if (a.substring(j, j + 1).equals("R")) {
					map[i][j] = 1;
				} else if (a.substring(j, j + 1).equals("G")) {
					map[i][j] = 2;
				} else if (a.substring(j, j + 1).equals("B")) {
					map[i][j] = 3;
				} else if (a.substring(j, j + 1).equals("P")) {
					map[i][j] = 4;
				} else if (a.substring(j, j + 1).equals("Y")) {
					map[i][j] = 5;
				}
			}
		}

		int result = 0;
		while (true) {
			chk = false;
			down();
			check = new int[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != 0 && check[i][j] == 0) {
						bfs(i, j, map[i][j]);
					}
				}
			}

			if(chk) {
				result += 1;
			}else {
				break;
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void down() {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (map[j][i] != 0) {
					al.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			
			int c = al.size();
			int w = 0;
			for (int z = 11; z > 11 - c; z--) {
				map[z][i] = al.get(w);
				w+=1;
			}
			al.clear();
		}
	}

	static void bfs(int x, int y, int c) {
		Queue<puyo> q = new LinkedList<>();
		ArrayList<puyo> store = new ArrayList<>();
		q.add(new puyo(x, y, c));
		store.add(new puyo(x, y, c));
		check[x][y] = map[x][y];
		
		while (!q.isEmpty()) {
			puyo now = q.poll();
			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > 11 || ny > 5)
					continue;
				if (check[nx][ny] > 0)
					continue;
				if (map[nx][ny] != now.color)
					continue;

				q.add(new puyo(nx, ny, now.color));
				store.add(new puyo(nx, ny, now.color));
				check[nx][ny] = now.color;
			}
		}
		if (store.size() >= 4) {
			chk = true;
			int d = store.size();
			for (int i = 0; i < d; i++) {
				map[store.get(i).x][store.get(i).y] = 0;
			}
		}
	}
}
