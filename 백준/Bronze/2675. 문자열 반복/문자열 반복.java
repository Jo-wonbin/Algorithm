import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (cnt++ < T){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            for(int i=0; i<word.length(); i++){
                char temp = word.charAt(i);
                for(int j=0; j<N; j++){
                    sb.append(temp);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}