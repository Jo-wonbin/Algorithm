import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while (cnt < N) {
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }
        count = 0;

        int start = 0;
        int end = 0;
        int temp = 0;
        while(start <= end && start < N && end < N){
            temp += arr[end];
            end++;
            if(temp == M){
                count++;
                start++;
                end = start;
                temp = 0;
            }else if(temp > M){
                start++;
                end = start;
                temp = 0;
            }
        }

        System.out.println(count);

        br.close();
    }



}