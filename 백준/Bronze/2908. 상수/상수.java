import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        String y = st.nextToken();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=2; i>=0; i--){
            sb1.append(x.charAt(i));
            sb2.append(y.charAt(i));
        }

        String temp = Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString()) ? sb1.toString() : sb2.toString();

        System.out.println(temp);
        br.close();
    }

}