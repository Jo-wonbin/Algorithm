package BOJweek2;
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
		 
		for (int i = 0; i < 9; i++) {       // row행의 열값이 value이면 false
			if (map[row][i] == value) {
				return false;
			}
		}
	    
		for (int i = 0; i < 9; i++) {		// col열의 행값이 value이면 false
			if (map[i][col] == value) {
				return false;
			}
		}
	 
	    
		int row1 = (row / 3) * 3;	
		int col1 = (col / 3) * 3;	
	 
		for (int i = row1; i < row1 + 3; i++) {		// 3*3 크기에서 값 비교
			for (int j = col1; j < col1 + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}
	 
		return true;	
	}
	
	static void dfs(int x, int y) throws IOException{
		
		if(y == 9) {		// 열의 크기기 9이면 행을 1증가시키고 열을 초기화해서 동작
			dfs(x+1, 0);
			return;
		}
				
		if(x == 9) {			// 행의 크기가 9이면 모든 값들을 출력시키고 종료
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
		
		if(map[x][y] == 0) {				// 0값을 찾으면 check하고 중복되지 않은 값을 넣어줌
			for(int i=1; i<=9; i++) {
				if(check(x, y, i)) {
					map[x][y] = i;
					dfs(x,y+1);				// 같은 행의 다음 열에서 dfs 호출
				}
			}
			
			map[x][y]=0;			// 수가 여러개 들어갈 경우를 위해 0초기화
			return;
		}
		
		dfs(x,y+1);  // 모든 조건 만족안하면 옆 행의 dfs호출
		
	}

}
