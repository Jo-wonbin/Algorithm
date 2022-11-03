package BOJ.BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1748 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();

		long num = Long.parseLong(n);
		long num1 = num;
		long cnt = 1;
		long sum = 0;
		while (true) {
			cnt += 1;
			num = num / 10;
			if (num < 10 && num >= 0) {
				break;
			}
		}
//		bw.write(num1+ "\n");
//		bw.write(cnt+ "\n");
//		bw.write("----------------"+ "\n");
		
		if ( num1 < 10 ) { // 1�ڸ��� �Էµ��ö�
			bw.write(num1 + "");
		} else {
			for (long i = 1; i <= cnt; i++) {
				if(i == 1) {
					sum = sum + 9;
//					bw.write(sum+ "*****"+"\n");
				}
				else if(i < cnt) {
					sum = sum + ((9*i) * (long)Math.pow(10, i-1));
//					bw.write(sum+ "%%%%% "+"\n");
				}else {
					long result = num1 - (long)Math.pow(10, cnt-1) + 1;
					sum = sum + (result * cnt);
//					bw.write(sum+ "&&&&& "+"\n");
				}
			}
			bw.write(sum + "");
		}



		br.close();
		bw.flush();
		bw.close();
	}

}
