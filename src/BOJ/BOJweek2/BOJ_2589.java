package BOJ.BOJweek2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589 {

	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,m;
	static char[][] map;
	static int[][]check;

	static int dx[] = { -1, 0, 1, 0 }; //�������
	static int dy[] = { 0, 1, 0, -1 };
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String a[] = br.readLine().split(" ",2);
	    n = Integer.parseInt(a[0]);
	    m = Integer.parseInt(a[1]);
	    
	    map=new char[n+1][m+1];

	    check=new int[n+1][m+1];
	    
	    for (int i = 1; i <= n; i++) {
	         for (int j = 1; j <= m; j++) {
	            	check[i][j]= -1;
	         }
	    }
	    
	    for (int i = 1; i <= n; i++) {
	         String b = br.readLine();
	         for (int j = 1; j <= m; j++) {

	            map[i][j] = b.charAt(j-1); // ���ڿ��� ���������� 2���� �迭�� ����
	            
	         }
	    }
	    
	    for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) { 
                if(map[i][j] == 'L') { 
                    bfs(i,j);
                }
               }
           }
 
        Collections.sort(al);

       // for(int y : al)
        int c = al.size();
        bw.write(al.get(c-1)+"\n");
        
        br.close();
        bw.flush();
        bw.close();
	    
	}
	
	static void bfs(int i, int j)  {
        int nx,ny;

        q.offer(new Point(i,j));     // ť���ٰ� Point ��ǥ�� �ּ� ����
        check[i][j]++;     // �ߺ� üũ
        int cnt = 0 ;
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // �����¿� �˻�
            ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m)
            	continue;								// ���� ������ ���� �ʰ�
            if(map[nx][ny] == 'W')     // ������ L�̰� �ߺ��� �ƴϸ�
            	continue;
            if(check[nx][ny] > -1)
            	continue;
            											
            q.offer(new Point(nx,ny));         // ť�� �ش� ��ǥ�� ť�� ����
            check[nx][ny] = check[now.x][now.y]+1; 				// ���� ��ǥ�� ���� ���� ��ǥ +1 ��.

            }
            
        }
        for(int a=1; a<=n; a++) {						// ��ü �迭 �� ��ǥ���� ���� ū ���� ã��.
        	for(int b=1; b<=m; b++) {
        		cnt = Math.max(cnt,  check[a][b]);
        	}
        }
        
        al.add(cnt);
        for (int c = 1; c <= n; c++) {				// üũ �ʱ�ȭ
	         for (int d = 1; d <= m; d++) {
	            	check[c][d]= -1;
	         }
	    }
        
	}
}
