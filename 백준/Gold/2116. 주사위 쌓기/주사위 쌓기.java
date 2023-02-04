import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, result;
    static int[][] dice;
    static int[][] state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dice = new int[N][6];
        state = new int[N][6];

        result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < 6; i++) {
            diceUp(0, i, 0);
            countMax();
        }

        System.out.println(result);

        br.close();

    }

    static void diceUp(int row, int index, int upSide) {
        if (row == N) {
            return;
        }

        if (row == 0) {
            for (int i = 0; i < 6; i++) {
                state[row][i] = 0;
            }

        } else {
            for (int i = 0; i < 6; i++) {
                state[row][i] = 0;
                if (dice[row][i] == upSide) {
                    index = i;
                }
            }
        }

        state[row][index] = 1;

        if (index == 0) {
            index = 5;
        } else if (index == 2 || index == 1) {
            index += 2;
        } else if (index == 4 || index == 3) {
            index -= 2;
        } else {
            index = 0;
        }
        state[row][index] = 2;
        upSide = dice[row][index];
        diceUp(row + 1, index, upSide);

    }


    static void countMax() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < 6; j++) {
                if (state[i][j] == 0) {
                    max = Math.max(max, dice[i][j]);
                }
            }
            count += max;
        }

        result = Math.max(count, result);
    }


}