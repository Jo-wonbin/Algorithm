package BOJ.BOJweek4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {

	static Queue<Integer> q = new LinkedList<>();
	static int n, k;
	static int check[];
	static int next[];
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		check = new int[1000001];
		next = new int[1000001];

		Arrays.fill(check, -1);

		bfs();

		bw.write(check[k] + "\n"); // �ᱹ �� ��ġ�� ���� ���� ������ Ƚ���� ���
		
		int index = k;
		int cnt = 0;
		while(cnt <= check[k]) {
			al.add(index);
			index = next[index];
			cnt += 1;
		}

		for(int i=al.size()-1; i>=0; i-- ) {
			bw.write(al.get(i)+" ");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() { // �ϴ� ť�� �� ����ְ� �� ���� �ش��ϴ� +1, -1, x2 ������ ������.
		Queue<Integer> q = new LinkedList<>();

		q.add(n); // ť�� n�� ����

		check[n] = 0;
		while (!q.isEmpty()) {
			n = q.poll(); // n�� q�� ù��° �� ���� �� ť���� ����

			if (n == k) {
				break;
			}

			if (n * 2 <= 100000 && check[n * 2] == -1) { // n*2 �� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
				q.add(n * 2);
				check[n * 2] = check[n] + 1;
				next[n * 2] = n;
			}

			if (n + 1 <= 100000 && check[n + 1] == -1) { // n+1�� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
				q.add(n + 1);
				check[n + 1] = check[n] + 1;
				next[n + 1] = n;
			}

			if (n - 1 >= 0 && check[n - 1] == -1) { // n-1�� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
				q.add(n - 1);
				check[n - 1] = check[n] + 1;
				next[n - 1] = n;
			}

		}

	}
}
