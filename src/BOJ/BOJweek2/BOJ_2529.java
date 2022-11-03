package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2529 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char []list;
	static boolean []check;
	static int[]num;
    static int n;
    static ArrayList<String> al = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a = br.readLine();
	    n = Integer.parseInt(a);
		
	    list = new char[10];
	    check = new boolean[10];
	    num = new int [10];
	    
	    String b[] = br.readLine().split(" ", n);
	    for(int i=0; i < n;i++) {
            list[i] = b[i].charAt(0);
	    }
	    
	  
	    dfs(0);
	    
	  
	    int c = al.size();
	    bw.write(al.get(c-1));
	    bw.write(al.get(0));
	    br.close();
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int cnt) throws IOException{
		
		if(cnt == n+1) {
			String s = "";
			for(int i=0; i<=n; i++)
				s = s+num[i];
			s = s + "\n";
			
			al.add(s);
		
			return;
		}
		else {
			for(int i=0; i <= 9; i++) {
			
				if(check[i]) continue;
				if(cnt>0  && list[cnt-1] == '<' && num[cnt-1] >= i) continue;
				if(cnt>0  && list[cnt-1] == '>' && num[cnt-1] <= i) continue;
				num[cnt] = i;
				check[i] = true;
				dfs(cnt+1);
				check[i] = false;
			}
		
		}		
	}
		
	
	
}
