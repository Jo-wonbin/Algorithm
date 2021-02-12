package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_2105 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T, n;
	static int count = 0;
	static int cnt, result;
	static int[][]map;
	static boolean[][] check;
	static int[] dx = {1,1,-1,-1}; // 시계방향 대각선
	static int[] dy = {-1,1,1,-1};
	static ArrayList<Integer> al = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a = br.readLine();
		T = Integer.parseInt(a);
		
		while(count != T) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			map = new int[n+1][n+1];
			check = new boolean[n+1][n+1];
			
			for(int i=1; i<=n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
				}
			}

			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					
					set.clear();
					check = new boolean[n+1][n+1];
					check[i][j] = true;
					set.add(map[i][j]);
					dfs(i, j, i, j, 0);
					set.add(map[i][j]);
					check[i][j] = false;
				}
			}
				
			bw.write("#" + (count+1) + " " + result +"\n");
			count+=1;
			result = -1;
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs(int x, int y, int stx, int sty, int curve) throws IOException {
            
        for(int h=curve;h<4; h++) {
        	int nx = x+dx[h];
            int ny = y+dy[h];
            
            if(set.size() >= 4 && nx == stx && ny == sty) {
            		
            	cnt = set.size();
            	result = Math.max(result, cnt);
            	
            	
           	}
           		
            	
            	
           	if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
           	if(check[nx][ny]) continue;
           	if(set.contains(map[nx][ny])) continue;
           	
           	check[nx][ny] = true;
			set.add(map[nx][ny]);
			dfs(nx, ny, stx, sty, h);
			set.remove(map[nx][ny]);
			check[nx][ny] = false;
            
            
            }
       
	}

	
}
