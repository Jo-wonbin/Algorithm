package BOJ.BOJweek2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2580 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [][]map = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
		for (int i = 0; i < 9; i++) {
	         StringTokenizer st = new StringTokenizer(br.readLine()," ");
	         for (int j = 0; j < 9; j++) {

	            map[i][j] = Integer.parseInt(st.nextToken());
	            
	         }
	    }
		
		dfs(0, 0);
		
		
	}
	
	
	public static boolean check(int row, int col, int value) {
		 
		for (int i = 0; i < 9; i++) {       // row���� ������ value�̸� false
			if (map[row][i] == value) {
				return false;
			}
		}
	    
		for (int i = 0; i < 9; i++) {		// col���� �ప�� value�̸� false
			if (map[i][col] == value) {
				return false;
			}
		}
	 
	    
		int row1 = (row / 3) * 3;	
		int col1 = (col / 3) * 3;	
	 
		for (int i = row1; i < row1 + 3; i++) {		// 3*3 ũ�⿡�� �� ��
			for (int j = col1; j < col1 + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}
	 
		return true;	
	}
	
	static void dfs(int x, int y) throws IOException{
		
		if(y == 9) {		// ���� ũ��� 9�̸� ���� 1������Ű�� ���� �ʱ�ȭ�ؼ� ����
			dfs(x+1, 0);
			return;
		}
				
		if(x == 9) {			// ���� ũ�Ⱑ 9�̸� ��� ������ ��½�Ű�� ����
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			
			bw.write(sb+"");
			
			br.close();
			bw.flush();
			bw.close();
			
			System.exit(0);
			
		}
		
		if(map[x][y] == 0) {				// 0���� ã���� check�ϰ� �ߺ����� ���� ���� �־���
			for(int i=1; i<=9; i++) {
				if(check(x, y, i)) {
					map[x][y] = i;
					dfs(x,y+1);				// ���� ���� ���� ������ dfs ȣ��
				}
			}
			
			map[x][y]=0;			// ���� ������ �� ��츦 ���� 0�ʱ�ȭ
			return;
		}
		
		dfs(x,y+1);  // ��� ���� �������ϸ� �� ���� dfsȣ��
		
	}

}
