package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_4963 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int w, h, cnt;
	static boolean check[][];
	static int list[][];
	static ArrayList<Integer> arr;
	static int dx[] = { -1, 0, 1, 0, -1, -1, 1, 1 }; //�������
	static int dy[] = { 0, 1, 0, -1, -1 , 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	     while(true) {
	    	 
	    	 String a[] = br.readLine().split(" ",2);
		     w = Integer.parseInt(a[0]);
		     h = Integer.parseInt(a[1]);
	    	 
		     if(w == 0 && h == 0)
		    	 break;
		     else {
		     
		     list=new int[h+1][w+1];
		     check = new boolean [h+1][w+1];
		     arr = new ArrayList<Integer>();
	    	 
	    	 for (int i = 1; i <= h; i++) {
		         String b[] = br.readLine().split(" ");
		         for (int j = 1; j <= w; j++) {

		            list[i][j] = Integer.parseInt(b[j-1]); // ���ڿ��� ���������� 2���� �迭�� ����

		         }
		     }
	    	 
	    	 cnt = 0;
	    	 for (int i = 1; i <= h; i++) {
	    		 for (int j = 1; j <= w; j++) {
	    			 if (list[i][j] != 0 && check[i][j] == false) { // 0�� �ƴϰ� �ߺ��� �ƴϸ�
	    				 // System.out.println(i + " " + j);
	                   
	    				 dfs(i, j, cnt); // dfs����
	    				 cnt++;
	    				 arr.add(cnt);           // ���� �迭�� ���� ���� ����
	    				 //  System.out.println(cntA);

	    			 }
	    		 }
	    	 }
	    	 bw.write(cnt+"\n");
	    	 
		     }
	     }
	     br.close();
	     bw.flush();
	     bw.close();
	     
	}
	
	static void dfs(int x, int y, int a) {
	      
	      check[x][y] = true;

	      for (int i = 0; i < 8; i++) {
	         int mx = x + dx[i];
	         int my = y + dy[i];


	         if (mx < 1 || my < 1 || mx > h || my > w )
	            continue;
	         if (list[mx][my] == 0 )
	            continue;
	         if (check[mx][my])
	            continue;
	         check[mx][my] = true;
	         
	         dfs(mx, my, a);

	      }
	   }
}
