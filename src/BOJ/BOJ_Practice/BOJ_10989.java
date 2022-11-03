package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10989 { // ī���� ����

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int result[] = new int[n];
		int count[] = new int[10003];
		int max=0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st1.nextToken());
			max = Math.max(max, arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			count[temp] += 1;
		}

		for (int i = 0; i < max; i++) {
				int temp = count[i] + count[i + 1];
				count[i + 1] = temp;
			
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[i];
			count[temp] -= 1;
			int temp2 = count[temp];
			result[temp2] = temp;
		}

		for (int i = 0; i < result.length; i++)
			bw.write(result[i] + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

}
