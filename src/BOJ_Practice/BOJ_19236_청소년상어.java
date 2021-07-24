package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class shk {
	int x, y, size, dir;

	shk(int x, int y, int size, int dir) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.dir = dir;
	}
}

class fish {
	int x, y, size, dir;
	boolean alive;

	fish(int x, int y, int size, int dir, boolean alive) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.dir = dir;
		this.alive = alive;
	}

}

public class BOJ_19236_청소년상어 {

	static int result = Integer.MIN_VALUE;
	static List<fish> al = new ArrayList<>();
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int map[][] = new int[4][4];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken()) - 1;
				al.add(new fish(i, j, n, k, true));
				map[i][j] = n;

			}
		}

		Collections.sort(al, new Comparator<fish>() {

			@Override
			public int compare(fish o1, fish o2) {
				// TODO Auto-generated method stub
				return o1.size - o2.size;
			}
		});

		fish fish = al.get(map[0][0] - 1);
		shk shark = new shk(0, 0, fish.size, fish.dir);
		al.get(map[0][0] - 1).alive = false;
		map[0][0] = -1;

		dfs(map, shark, al);
		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int[][] map, shk shark, List<fish> al) {
		if (result < shark.size) {
			result = shark.size;
		}

		int c = al.size();
		for (int i = 0; i < c; i++) {
			fish f = al.get(i);
			move(f, map, al);
		}

		for (int h = 1; h < 4; h++) {
			int nd = shark.dir;
			int nx = shark.x + (dx[nd] * h);
			int ny = shark.y + (dy[nd] * h);

			if (nx < 0 || ny < 0 || nx > 3 || ny > 3)
				continue;
			if (map[nx][ny] <= 0)
				continue;

			int copy[][] = copy(map);
			List<fish> copylist = copylist(al);

			copy[shark.x][shark.y] = 0;
			fish f = copylist.get(map[nx][ny] - 1);
			shk ns = new shk(f.x, f.y, shark.size + f.size, f.dir);
			f.alive = false;
			copy[f.x][f.y] = -1;

			dfs(copy, ns, copylist);
		}
	}

	static void move(fish fish, int[][] map, List<fish> al) {
		if (!fish.alive)
			return;

		for (int h = 0; h < 8; h++) {
			int nd = (fish.dir + h) % 8;
			int nx = fish.x + dx[nd];
			int ny = fish.y + dy[nd];

			if (nx < 0 || ny < 0 || nx > 3 || ny > 3)
				continue;
			if (map[nx][ny] == -1)
				continue;

			map[fish.x][fish.y] = 0;

			if (map[nx][ny] == 0) {
				fish.x = nx;
				fish.y = ny;
			} else {
				fish temp = al.get(map[nx][ny] - 1);
				temp.x = fish.x;
				temp.y = fish.y;
				map[fish.x][fish.y] = temp.size;

				fish.x = nx;
				fish.y = ny;
			}
			map[nx][ny] = fish.size;
			fish.dir = nd;
			return;
		}
	}

	static int[][] copy(int[][] map) {
		int temp[][] = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	static List<fish> copylist(List<fish> al) {
		List<fish> temp = new ArrayList<>();
		int c = al.size();
		for (int i = 0; i < c; i++) {
			fish f = al.get(i);
			temp.add(new fish(f.x, f.y, f.size, f.dir, f.alive));
		}
		return temp;
	}
}
