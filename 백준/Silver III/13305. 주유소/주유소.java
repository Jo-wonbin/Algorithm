import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long price[] = new long[N];
        long dist[] = new long[N - 1];
        StringTokenizer st;

        long totalDist = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            long temp = Long.parseLong(st.nextToken());
            totalDist += temp;
            dist[i] = temp;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long nowPrice = price[0] * totalDist;
        long minPrice = price[0];
        long driveDist = dist[0];
        for (int i = 1; i < N - 1; i++) {
            if(minPrice > price[i]){
                totalDist -= driveDist;

                nowPrice -= (minPrice * totalDist);
                nowPrice += (price[i] * totalDist);

                minPrice = price[i];
                driveDist = dist[i];
            }else{
                driveDist += dist[i];
            }
        }


        System.out.println(nowPrice);
        br.close();
    }
}