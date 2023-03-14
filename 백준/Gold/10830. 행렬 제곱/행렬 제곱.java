import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final int thousand = 1000;
    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % thousand;
            }
        }

        int result[][] = pow(matrix, B);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();

    }

    static int[][] mult(int[][] a, int[][] b) {
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int x = 0; x < N; x++) {
                    arr[i][j] += a[i][x] * b[x][j];
                }
                arr[i][j] %= thousand;
            }
        }

        return arr;
    }

    static int[][] pow(int[][] A, long exp) {

        if (exp == 1L) {
            return A;
        }

        int[][] temp = pow(A, exp / 2);

        temp = mult(temp, temp);

        return exp % 2L == 1 ? mult(temp, matrix) : temp;
    }


}