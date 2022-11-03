package BOJ.BOJweek2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {

	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,m;
	static int cnt = 0;
	static int [][] map;
	static int [][]check;
	static int dx[] = { -1, 0, 1, 0 }; //�������
	static int dy[] = { 0, 1, 0, -1 };
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String b[] = br.readLine().split(" ", 2);
		n = Integer.parseInt(b[0]);
		m = Integer.parseInt(b[1]);
	
		map = new int [m+1][n+1];
		check = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				check[i][j] = -1;
			}
		}
		
		
		for(int i=1; i<=m; i++) {
			String a[] = br.readLine().split(" ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(a[j-1]);
			}
		
		}
		bfs();
		
		Loop1:
	   	for(int i=1; i<=m; i++) {
	    	for(int j=1; j<=n; j++) {
	    		if(map[i][j] ==0) {
	    			al.add(-1);
	    			break Loop1;
	    		}
	    	}			
	    }
		al.add(cnt);
		bw.write(al.get(0)+"");
		
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() throws IOException {
		int nx,ny;
		int a;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] == 1 && check[i][j] == -1) {
					q.offer(new Point(i,j));
					check[i][j] = 0;
				}
			}
		}
      
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // �����¿� �˻�
            ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > m || ny > n)
            	continue;								// ���� ������ ���� �ʰ�
            if(map[nx][ny] == -1)     // ������ -1�� �ƴϰ� �ߺ��� �ƴϸ�
            	continue;
            if(map[nx][ny] == 1)
            	continue;
            if(check[nx][ny] > -1)
            	continue;
            											
            q.offer(new Point(nx,ny));
            map[nx][ny] = 1;				
            check[nx][ny] = check[now.x][now.y]+1; 				// ���� ��ǥ�� ���� ���� ��ǥ +1 ��.

            }
            
        }
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		cnt = Math.max(cnt, check[i][j]);
        	}
        }
        
    }
	
	
}
