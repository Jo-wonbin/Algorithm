package BOJ.BOJweek1;
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

		boolean robot[] = new boolean[n + 1]; // �κ�

		String b[] = br.readLine().split(" ");

		for (int i = 1; i <= 2 * n; i++) {
			belt[i] = Integer.parseInt(b[i - 1]); // ������ �Է�

		}
		
		int cnt = 0;
		while (true) {
			cnt++;
			// �����̾� ��Ʈ ȸ�� 
			int tp = belt[2 * n]; // 2*n�� �������� tp�� ��� �Ƥӵ��� ���� �� belt[1]�� �̵� 
			for (int i = 2 * n; i > 1; i--) {

				belt[i] = belt[i-1]; 
				if(!(i>n) && (robot[i-1] == true)) { // i�� n�̻��̰� ��-1�� �κ��� ������
					robot[i] = robot[i-1];  // i���ٰ� �κ��� �ΰ�
					robot[i-1] = false; // i-1�� �κ��� ����ٰ� ����
				}
				

			}
			belt[1] = tp; // ù��° �����̾Ʈ�� belt[2*n]���� ����
			
			robot[n] = false; // �������� ��ġ�� �κ��� ��ġ�Ѵٸ� �ٷ� �����ش�. 
			
			for(int i = n;i > 1;i--) {
				if(robot[i] == false && robot[i-1] == true && belt[i] > 0) // ���� ��ġ�� �κ��� ����  �̵���ų ��ġ������ �κ��� �ְ�, �������� 0���� ũ�ٸ� 
				{
					robot[i] = robot[i-1];  // �κ��� �̵��ϰ�
					robot[i-1] = false; 
					belt[i]--; // ��Ʈ�� �������� 1 ������.
				}
			}
			robot[n] = false; // �������� ��ġ�� �κ��� ��ġ�Ѵٸ� �ٷ� �����ش�. 

			// �ö󰡴� ��ġ���� �κ��� ���� �������� 0���� ũ��
			if(!robot[1] && belt[1] > 0) {
				robot[1]= true; // true�� �κ��� �÷��ְ�
				belt[1]--;  // ��Ʈ �������� �����ش�.
			}

			int zero = 0; // ������ 0�� üũ�ϱ� ���� ����  
			
			for(int i=1; i <= 2*n; i++) {
				if(belt[i] == 0)zero++;//������ 0 üũ 
				  
			}
			
			if(zero >= k) break;
		}
		
		System.out.println(cnt);
		bw.close();
	}

}
