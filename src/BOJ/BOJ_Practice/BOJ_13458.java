package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		int n = Integer.parseInt(a);
		long map[] = new long[n];
		long min = 0;
		long max = 0;
		double num = 0;
		double count = 0;
		int cnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			map[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, map[i]);
			min = Math.min(min, map[i]);
		}

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		long king = Long.parseLong(st1.nextToken());
		long slave = Long.parseLong(st1.nextToken());

		// bw.write(king +" "+slave + "\n");

		for (int i = 0; i < n; i++) {
			num = map[i] - king;
			if (num <= 0) {
				count += 1;
				continue;
			}
			if (slave != 1) {
				count = count + Math.ceil(num / slave);
				cnt += 1;
			} else {
				count = count + (double) num;
				cnt += 1;
			}
		}

		bw.write((long) count + cnt + "");

		br.close();
		bw.flush();
		bw.close();
	}

}
