package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2750 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			al.add(Integer.parseInt(st1.nextToken()));
		}
		
		Collections.sort(al);
		for(int i=0; i<al.size(); i++)
			bw.write(al.get(i)+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
