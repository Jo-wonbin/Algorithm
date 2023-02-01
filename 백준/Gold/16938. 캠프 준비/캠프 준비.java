import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, L, R, X, result;
    static int[] difficult;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        difficult = new int[N];

        for (int i = 0; i < N; i++) {
            difficult[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        for(int i=1; i<=N; i++){
            temp = new int[i];
            comb(0, 0, i);
        }

        System.out.println(result);

        br.close();

    }

    static void comb(int cnt, int now, int end){
        if(cnt == end){

            int sum = 0;
            int max = 0;
            int min = 1000001;
            for(int tp : temp){
                sum += tp;
                max = Math.max(max,  tp);
                min = Math.min(min, tp);
            }

            if(L <= sum && sum <= R && max - min >= X)
                result++;

            return;
        }

        for(int i=now; i<N; i++){
            temp[cnt] = difficult[i];
            comb(cnt+1, i+1, end);
        }
    }

}