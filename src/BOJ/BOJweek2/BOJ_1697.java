package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	
	static Queue<Integer> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,k;
	static int check[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		check = new int [1000001];
		
		Arrays.fill(check,-1);
		
		bfs();
		
		bw.write(check[k]+"");      // �ᱹ �� ��ġ�� ���� ���� ������ Ƚ���� ���
		
		br.close();
		bw.flush();
		bw.close();
	}

	
	static void bfs() throws IOException  { // �ϴ� ť�� �� ����ְ� �� ���� �ش��ϴ� +1, -1, x2 ������ ������.

		q.add(n); // ť�� n�� ����
		check[n] = 0;
        while(!q.isEmpty())  {
            n = q.poll();         // n�� q�� ù��° �� ���� �� ť���� ����
            
            if(n == k) {	
            	break;
            }
 
            if(n*2 <= 100000 && check[n*2] == -1) {  // n*2 �� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
            	q.add(n*2);
            	check[n*2] = check[n]+1;
            }
            
            if(n+1 <= 100000 && check[n+1] == -1) {  // n+1�� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
            	q.add(n+1);
            	check[n+1] = check[n]+1;
            }
            
            if(n-1 >= 0 && check[n-1] == -1) {   // n-1�� ��ġ�� ������� üũ�� ��ġ�� ���� üũ+1����
            	q.add(n-1);
            	check[n-1] = check[n]+1;
            }

        }

	}
}
