import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (st.hasMoreTokens()) {
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;

        if (find()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }


        br.close();
    }

    static boolean find() {

        int i = N - 1;

        while (i > 0 && arr[i - 1] > arr[i]) { // 마지막 내림차순 인덱스 찾기
            i--;
        }
        if (i == 0)     // 모두 내림차순이면 -1
            return false;

        int j = N - 1;
        while (arr[i - 1] > arr[j]) {   // 하위 내림차순에서 가장 큰 수를 가진 인덱스 찾기
            j--;
        }

        swap(i - 1, j); // 스왑

        j = N - 1;
        while (i < j) { // 하위 내림차순 오름차순으로 변환
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return;
    }

}