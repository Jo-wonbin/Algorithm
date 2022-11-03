package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> s = new HashSet<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		}
		int cnt = 0;
		String arr[] = new String[s.size()];
		Iterator<String> itr = s.iterator();

		while (itr.hasNext()) {
			arr[cnt] = itr.next();
			cnt++;
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() == o2.length()) { // ���̰� ���� �� ���������� ����
					return o1.compareTo(o2);
				} else
					return o1.length() - o2.length(); // ���� ���ڿ��� ũ�� �ٲ�
			}

		});
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
