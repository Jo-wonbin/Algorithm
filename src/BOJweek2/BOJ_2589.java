package BOJweek2;

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

	static int dx[] = { -1, 0, 1, 0 }; //상우하좌
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

	            map[i][j] = b.charAt(j-1); // 문자열을 개별단위로 2차원 배열에 저장
	            
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

        q.offer(new Point(i,j));     // 큐에다가 Point 좌표의 주소 저장
        check[i][j]++;     // 중복 체크
        int cnt = 0 ;
        while(!q.isEmpty()) 
        {
            Point now = q.poll();        // 큐값을 now에 저장하고 삭제
            
            for(int h=0;h<4;h++) {
            nx = now.x+dx[h];    // 상하좌우 검사
            ny = now.y+dy[h];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m)
            	continue;								// 지도 범위를 넘지 않고
            if(map[nx][ny] == 'W')     // 지도가 L이고 중복이 아니면
            	continue;
            if(check[nx][ny] > -1)
            	continue;
            											
            q.offer(new Point(nx,ny));         // 큐에 해당 좌표을 큐에 넣음
            check[nx][ny] = check[now.x][now.y]+1; 				// 다음 좌표의 값을 현재 좌표 +1 함.

            }
            
        }
        for(int a=1; a<=n; a++) {						// 전체 배열 중 좌표값이 가장 큰 것을 찾음.
        	for(int b=1; b<=m; b++) {
        		cnt = Math.max(cnt,  check[a][b]);
        	}
        }
        
        al.add(cnt);
        for (int c = 1; c <= n; c++) {				// 체크 초기화
	         for (int d = 1; d <= m; d++) {
	            	check[c][d]= -1;
	         }
	    }
        
	}
}
