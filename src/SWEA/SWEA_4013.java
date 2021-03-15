package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4013 {
	static int k, c, d;
	static int map[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String a = br.readLine();
		int num = Integer.parseInt(a);

		int count = 1;
		while (count <= num) {

			String h = br.readLine();
			k = Integer.parseInt(h);

			map = new int[5][8];
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 1; i < 5; i++) {
//				for (int j = 0; j < 8; j++) {
//					bw.write(map[i][j]+" ");
//				}
//				bw.write("\n");
//			}
//			bw.write("------^^^--------\n");
			
			for (int s = 0; s < k; s++) {
				String b[] = br.readLine().split(" ");
				c = Integer.parseInt(b[0]);
				d = Integer.parseInt(b[1]);

				rotate(c, d);
//				for (int i = 1; i < 5; i++) {
//					for (int j = 0; j < 8; j++) {
//						bw.write(map[i][j]+" ");
//					}
//					bw.write("\n");
//				}
//				bw.write("-----------------\n");
			}
			
//			for (int i = 1; i < 5; i++) {
//				for (int j = 0; j < 8; j++) {
//					bw.write(map[i][j]+" ");
//				}
//				bw.write("\n");
//			}
//			bw.write("-----------------\n");
			
			int cnt = 0;
			for (int i = 1; i < 5; i++) {
				if(i == 1 && map[i][0] == 1) {
					cnt += 1;
				}
				if(i == 2 && map[i][0] == 1) {
					cnt += 2;
				}
				if(i == 3 && map[i][0] == 1) {
					cnt += 4;
				}
				if(i == 4 && map[i][0] == 1) {
					cnt += 8;
				}
				
			}

			bw.write("#" + count + " " + cnt + "\n");

			count += 1;
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static void rotate(int num, int cul) {
		if (cul == 1) {// 시계방향
			int ns2 = map[num][2];// 굴리는 쪽 붙어있는 극 정보
			int ns6 = map[num][6];
			int temp = map[num][7];
			for (int i = 7; i >= 1; i--) {
				map[num][i] = map[num][i - 1];
			}
			map[num][0] = temp;

			if (num == 1) {
				if (map[2][6] != ns2) {// 반시게
					ns2 = map[2][2];
					int temp1 = map[2][0];
					for (int i = 0; i < 7; i++) {
						map[2][i] = map[2][i + 1];
					}
					map[2][7] = temp1;

					if (map[3][6] != ns2) {// 시게
						ns2 = map[3][2];
						int temp2 = map[3][7];
						for (int i = 7; i >= 1; i--) {
							map[3][i] = map[3][i - 1];
						}
						map[3][0] = temp2;

						if (map[4][6] != ns2) {// 반시계
							int temp3 = map[4][0];
							for (int i = 0; i < 7; i++) {
								map[4][i] = map[4][i + 1];
							}
							map[4][7] = temp3;
						}
					}
				}
			} else if (num == 2) {// 반시계
				if (map[1][2] != ns6) {
					int temp1 = map[1][0];
					for (int i = 0; i < 7; i++) {
						map[1][i] = map[1][i + 1];
					}
					map[1][7] = temp1;
				}

				if (map[3][6] != ns2) {// 반시계
					ns2 = map[3][2];
					int temp1 = map[3][0];
					for (int i = 0; i < 7; i++) {
						map[3][i] = map[3][i + 1];
					}
					map[3][7] = temp1;

					if (map[4][6] != ns2) {// 시계
						int temp2 = map[4][7];
						for (int i = 7; i >= 1; i--) {
							map[4][i] = map[4][i - 1];
						}
						map[4][0] = temp2;
					}
				}

			} else if (num == 3) {
				if (map[4][6] != ns2) {// 반시계
					int temp1 = map[4][0];
					for (int i = 0; i < 7; i++) {
						map[4][i] = map[4][i + 1];
					}
					map[4][7] = temp1;
				}

				if (map[2][2] != ns6) {// 반시계
					ns6 = map[2][6];
					int temp1 = map[2][0];
					for (int i = 0; i < 7; i++) {
						map[2][i] = map[2][i + 1];
					}
					map[2][7] = temp1;

					if (map[1][2] != ns6) {// 시계
						int temp2 = map[1][7];
						for (int i = 7; i >= 1; i--) {
							map[1][i] = map[1][i - 1];
						}
						map[1][0] = temp2;
					}
				}
			} else {
				if (map[3][2] != ns6) {// 반시게
					ns6 = map[3][6];
					int temp1 = map[3][0];
					for (int i = 0; i < 7; i++) {
						map[3][i] = map[3][i + 1];
					}
					map[3][7] = temp1;

					if (map[2][2] != ns6) {// 시게
						ns6 = map[2][6];
						int temp2 = map[2][7];
						for (int i = 7; i >= 1; i--) {
							map[2][i] = map[2][i - 1];
						}
						map[2][0] = temp2;

						if (map[1][2] != ns6) {// 반시계
							int temp3 = map[1][0];
							for (int i = 0; i < 7; i++) {
								map[1][i] = map[1][i + 1];
							}
							map[1][7] = temp3;
						}
					}
				}
			}
		} else if (cul == -1) {// 반시계방향
			int ns2 = map[num][2];// 붙어있는 극 정보
			int ns6 = map[num][6];
			int temp = map[num][0];
			for (int i = 0; i < 7; i++) {
				map[num][i] = map[num][i + 1];
			}
			map[num][7] = temp;

			if (num == 1) {
				if (map[2][6] != ns2) {// 시계
					ns2 = map[2][2];
					int temp1 = map[2][7];
					for (int i = 7; i >= 1; i--) {
						map[2][i] = map[2][i - 1];
					}
					map[2][0] = temp1;

					if (map[3][6] != ns2) {// 반시계
						ns2 = map[3][2];
						int temp2 = map[3][0];
						for (int i = 0; i < 7; i++) {
							map[3][i] = map[3][i + 1];
						}
						map[3][7] = temp2;

						if (map[4][6] != ns2) {// 시계
							int temp3 = map[4][7];
							for (int i = 7; i >= 1; i--) {
								map[4][i] = map[4][i - 1];
							}
							map[4][0] = temp3;
						}
					}
				}
			} else if (num == 2) {
				if (map[1][2] != ns6) {// 시계
					int temp1 = map[1][7];
					for (int i = 7; i >= 1; i--) {
						map[1][i] = map[1][i - 1];
					}
					map[1][0] = temp1;
				}
				if (map[3][6] != ns2) {// 시계
					ns2 = map[3][2];
					int temp1 = map[3][7];
					for (int i = 7; i >= 1; i--) {
						map[3][i] = map[3][i - 1];
					}
					map[3][0] = temp1;

					if (map[4][6] != ns2) {// 반시게
						int temp2 = map[4][0];
						for (int i = 0; i < 7; i++) {
							map[4][i] = map[4][i + 1];
						}
						map[4][7] = temp2;
					}
				}
			} else if (num == 3) {
				if (map[4][6] != ns2) {// 시계
					int temp1 = map[4][7];
					for (int i = 7; i >= 1; i--) {
						map[4][i] = map[4][i - 1];
					}
					map[4][0] = temp1;
				}

				if (map[2][2] != ns6) {// 시계
					ns6 = map[2][6];
					int temp1 = map[2][7];
					for (int i = 7; i >= 1; i--) {
						map[2][i] = map[2][i - 1];
					}
					map[2][0] = temp1;

					if (map[1][2] != ns6) {// 반시계
						int temp2 = map[1][0];
						for (int i = 0; i < 7; i++) {
							map[1][i] = map[1][i + 1];
						}
						map[1][7] = temp2;
					}
				}
			} else {
				if (map[3][2] != ns6) {// 시계
					ns6 = map[3][6];
					int temp1 = map[3][7];
					for (int i = 7; i >= 1; i--) {
						map[3][i] = map[3][i - 1];
					}
					map[3][0] = temp1;

					if (map[2][2] != ns6) {// 반시계
						ns6 = map[2][6];
						int temp2 = map[2][0];
						for (int i = 0; i < 7; i++) {
							map[2][i] = map[2][i + 1];
						}
						map[2][7] = temp2;

						if (map[1][2] != ns6) {// 시계
							int temp3 = map[1][7];
							for (int i = 7; i >= 1; i--) {
								map[1][i] = map[1][i - 1];
							}
							map[1][0] = temp3;
						}
					}
				}
			}
		}
	}
}
