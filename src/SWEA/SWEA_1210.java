package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
	int x;
	int y;

	location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_1210 {

	static Queue<location> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1 }; // ¿ìÁÂ»ó
	static int dy[] = { 1, -1, 0 };
	static boolean check[][];
	static int result = 0, y;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 1;
		while (count < 11) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int map[][] = new int[100][100];
			check = new boolean[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						q.add(new location(i,j));					// µµÂøÁ¡ À§Ä¡ ÀúÀå
						check[i][j] = true;
					}
				}
			}
			
			bfs(map);

			bw.write("#" + n + " " + result + "\n");
			result = 0;
			y = 0;
			count += 1;
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int map[][]) {
		while (!q.isEmpty()) {

			location now = q.poll();

			if (now.x == 0) {
				result = now.y;
				return;
			}
			Loop1:
			for (int h = 0; h < 3; h++) {
				int nx = now.x + dx[h]; // ÁÂ¿ì»ó °Ë»ç
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > 99 || ny > 99)
					continue;
				if (check[nx][ny])
					continue;
				if (map[nx][ny] == 0)
					continue;
				
				if( h == 0 || h == 1) {
					if(map[nx][ny] == 1) {
						check[nx][ny] = true;
						q.offer(new location(nx, ny));
						break Loop1;
					}
				}
				
				check[nx][ny] = true;
				q.offer(new location(nx, ny));
				

			}
		}
	}

}
