import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        int result = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            String temp = br.readLine();
            if(set.contains(temp)){
                result++;
                list.add(temp);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        for(String tp : list){
            sb.append(tp).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

}