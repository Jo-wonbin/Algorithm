package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {

   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static int n, cntA;
   static boolean check[][];
   static String list[][];
   static int dx[] = { -1, 0, 1, 0 }; //�������
   static int dy[] = { 0, 1, 0, -1 };

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub

      String a[] = br.readLine().split(" ");
      n = Integer.parseInt(a[0]);

      list = new String[n + 1][n + 1];
      check = new boolean[n + 1][n + 1];
      ArrayList<Integer> arr = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
         String b = br.readLine();
         for (int j = 1; j <= n; j++) {

            list[i][j] = b.substring(j - 1, j); // ���ڿ��� ���������� 2���� �迭�� ����

         }
      }
      int cntapart = 0;
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n; j++) {
            if (list[i][j].charAt(0) != '0' && check[i][j] == false) { // 0�� �ƴϰ� �ߺ��� �ƴϸ�
              // System.out.println(i + " " + j);
               cntA = 1;     
               dfs(i, j, cntapart);  // dfs����
               cntapart++; 				//������ ����Ʈ ������ 1����
               arr.add(cntA);           // ���� �迭�� ����Ʈ  �� ����
             //  System.out.println(cntA);

            }
         }
      }
      bw.write(cntapart + "\n");
      Collections.sort(arr);
      for(int i=0; i<arr.size(); i++) {
    	  bw.write(arr.get(i)+"\n");
      }
      
      br.close();
      bw.flush();
      bw.close();
   }

   static void dfs(int x, int y, int a) {
      
      check[x][y] = true;

      for (int i = 0; i < 4; i++) {
         int mx = x + dx[i];
         int my = y + dy[i];

         if (mx < 1 || my < 1 || mx > n || my > n)
            continue;
         if (list[mx][my].charAt(0) == '0')
            continue;
         if (check[mx][my])
            continue;
         check[mx][my] = true;
         cntA++;
         dfs(mx, my, a);

      }
   }
}