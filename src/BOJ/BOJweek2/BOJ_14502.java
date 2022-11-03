package BOJ.BOJweek2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502 {

	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,m;
	static int[][] map;
	static int[][] copy;
	static boolean[][]check;
	static int dx[] = { -1, 0, 1, 0 }; //�������
	static int dy[] = { 0, 1, 0, -1 };
	static int result = 0;
	
	//
	static void copyMap(int [][]map, int [][]copy) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	//
	static void wall(int cnt) {
		if(cnt == 3) {
			virus();
			return;
		}	
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<= m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	//
	static void virus() {
		
		copyMap(map, copy);
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!check[i][j] && copy[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(copy[i][j] == 0) {
					cnt+=1;
				}
			}
		}
		if(cnt>result)
			result = cnt;
	}

	
	//
	static void bfs(int i, int j)  {
        int nx,ny;
        copy[i][j] = 2;
        q.offer(new Point(i,j));     // ť���ٰ� Point ��ǥ�� �ּ� ����
        check[i][j] = true;     // �ߺ� üũ
        
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // ť���� now�� �����ϰ� ����
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // �����¿� �˻�
            ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m)
            	continue;								
            if(copy[nx][ny] == 1 || copy[nx][ny] == 2)     
            	continue;
            if(check[nx][ny])
            	continue;
            					
            check[nx][ny]=true;
            copy[nx][ny] = 2;
            q.offer(new Point(nx,ny));    
             				
            }
            
        }
        
        for(int a=1; a<=n; a++) {                       // üũ �ʱ�ȭ
			for(int b=1; b<=m; b++) {
				check[a][b] = false;
				
			}
		}
        
	}
	
	//
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String a[] = br.readLine().split(" ",2);
	    n = Integer.parseInt(a[0]);
	    m = Integer.parseInt(a[1]);
	    
	    map = new int[n+1][m+1];
	    copy = new int[n+1][m+1];
	    check = new boolean[n+1][m+1];
	    
	    for (int i = 1; i <= n; i++) {
	         String b[] = br.readLine().split(" ");
	         for (int j = 1; j <= m; j++) {

	            map[i][j] = Integer.parseInt(b[j-1]);
          
	         }
	    }
	    
	    
	    for(int i=1; i<=n; i++) {         // ���� Ž��
	    	for(int j=1; j<=m;  j++) {
	    		if(map[i][j] == 0) {
	    			map[i][j] = 1;
	    			wall(1);
	    			map[i][j] = 0;
	    		}
	    	}
	    }
	    
	    bw.write(result+"");
	    
	    br.close();
	    bw.flush();
	    bw.close();
	}
	
	
	
}
