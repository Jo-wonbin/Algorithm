package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2231 {

	static int n, len;
	static int first = 0;
	static ArrayList<Integer> al = new ArrayList<>();
	static boolean check[];
	static int map[];
	static double temp = 0;
	static double sum = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		first = Integer.parseInt(a.substring(0, 1));
		n = Integer.parseInt(a);
		len = a.length();
		map = new int[len];
		check = new boolean[len];

		for (int i = 1; i <= first; i++) {
			check[0] = true;
			map[0] = i;
			//System.out.print(i + " ");
			dfs(0);
			check[0] = false;
		}
		
//		for(int y : al) {
//			bw.write(y+ "\n");
//		}
		
		if (al.size() != 0) {
			Collections.sort(al);
			bw.write(al.get(0)+"");
		}else {
			bw.write("0");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int cnt) {

		if (cnt == len) {
			for (int i = 0; i < len; i++) {
				temp = temp + map[i] * Math.pow(10, len - 1 - i);
				sum = sum + (map[i] * Math.pow(10, len - 1 - i)) + map[i];
			}
			//System.out.print((int)sum + "%%%\n");
			if ((int) sum == n) {
				al.add((int) temp);
			}
			sum = 0;
			temp = 0;
			return;
		}

		for (int i = 0; i < 10; i++) {

			check[cnt] = true;
			map[cnt] = i;
			//System.out.print(i + "%%%");
			dfs(cnt + 1);
			check[cnt] = false;

		}
	}
}
