package BOJweek2;
import java.io.*;
import java.util.*;

public class BOJ_1260 {

	static int n;
	static ArrayList<Integer>[] list;
	static boolean check[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		int a,b;
		
		list = new ArrayList[n+1]; // 배열을 저장하는 배열을 만듦.
		
		for(int i=1; i<n+1; i++) {
			
			list[i] = new ArrayList<Integer>(); //배열 안에 배열 생성
			
		}
		
		for(int i=0; i<m; i++) {
			
			a = sc.nextInt();
			b = sc.nextInt();
			
			list[a].add(b); // a 접점의 노드 b를 저장
			list[b].add(a); // b 접점의 노드 a를 저장
			
		}
		
		for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

		
		check = new boolean [n+1]; // 중복을 체크하는 배열 초기화
		dfs(v);
		bw.write("\n");
		
		check = new boolean [n+1]; // 중복을 체크하는 배열 초기화
		bfs(v);
		bw.write("\n");
		
		sc.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v) throws IOException {
	
		check[v] = true; // 방문한 배열을 중복으로 선언
		
		bw.write(v+" "); // 빙문한 값 출력
		
		for(int y : list[v]) { // list[v]의 값을 y에 저장한 뒤 y번째가 중복이 아니면 반복
			
			if(!check[y]) {
				dfs(y);
			}
				
			
		}
		
	}
	
	
	static void bfs(int v) throws IOException {
		
		Queue<Integer> queue = new LinkedList<Integer>(); // 큐 생성
		queue.add(v);         // 큐에 시작할 접점 v값 넣음
		check[v] = true;      // 시작한 곳 방문했다고 처리해줌.
		
		while(!queue.isEmpty()) { // 큐가 비어있지 않으면 동작
			int x = queue.poll();  // x에 첫번째 큐의 값을 넣고 큐값 제거
			bw.write(x+" ");         // x값 출력
			for(int y : list[x]) {  // y에 list[x] 값을 순차적으로 입력
				
				if (!check[y]) {     // 중복이 아니면
					
					check[y] = true;  // 다녀간 노드에 중복처리하고
					queue.add(y);      //큐에 y값 저장
					
				}
				
			}
		}
		
	}

}
