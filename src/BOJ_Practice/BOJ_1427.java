package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> al = new ArrayList<>();
		
		String a = br.readLine();
		for(int i=0; i<a.length(); i++) {
			al.add(Integer.parseInt(a.substring(i, i+1)));
		}
		
		Collections.sort(al, Collections.reverseOrder());
		for(int y : al)
			bw.write(y+"");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
