package BOJweek1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ20055 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a[] = br.readLine().split(" ", 2);

		int n = Integer.parseInt(a[0]);
		int k = Integer.parseInt(a[1]);

		int belt[] = new int[2 * n + 1];

		boolean robot[] = new boolean[n + 1]; // 로봇

		String b[] = br.readLine().split(" ");

		for (int i = 1; i <= 2 * n; i++) {
			belt[i] = Integer.parseInt(b[i - 1]); // 내구도 입력

		}
		
		int cnt = 0;
		while (true) {
			cnt++;
			// 컨베이어 벨트 회전 
			int tp = belt[2 * n]; // 2*n의 내구도를 tp에 담아 아ㅣ동이 끝난 후 belt[1]로 이동 
			for (int i = 2 * n; i > 1; i--) {

				belt[i] = belt[i-1]; 
				if(!(i>n) && (robot[i-1] == true)) { // i가 n이상이고 ㅑ-1에 로봇이 있으면
					robot[i] = robot[i-1];  // i에다가 로봇을 두고
					robot[i-1] = false; // i-1은 로봇이 비었다고 설정
				}
				

			}
			belt[1] = tp; // 첫번째 컨베이어벨트에 belt[2*n]값을 저장
			
			robot[n] = false; // 내려가는 위치에 로봇이 위치한다면 바로 내려준다. 
			
			for(int i = n;i > 1;i--) {
				if(robot[i] == false && robot[i-1] == true && belt[i] > 0) // 현재 위치에 로봇이 없고  이동시킬 위치에서의 로봇이 있고, 내구도가 0보다 크다면 
				{
					robot[i] = robot[i-1];  // 로봇을 이동하고
					robot[i-1] = false; 
					belt[i]--; // 벨트의 내구도를 1 내린다.
				}
			}
			robot[n] = false; // 내려가는 위치에 로봇이 위치한다면 바로 내려준다. 

			// 올라가는 위치에서 로봇이 없고 내구도가 0보다 크면
			if(!robot[1] && belt[1] > 0) {
				robot[1]= true; // true로 로봇을 올려주고
				belt[1]--;  // 벨트 내구도를 내려준다.
			}

			int zero = 0; // 내구도 0을 체크하기 위한 변수  
			
			for(int i=1; i <= 2*n; i++) {
				if(belt[i] == 0)zero++;//내구도 0 체크 
				  
			}
			
			if(zero >= k) break;
		}
		
		System.out.println(cnt);
	}

}
