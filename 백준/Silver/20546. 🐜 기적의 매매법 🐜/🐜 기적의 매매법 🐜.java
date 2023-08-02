import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int chart[] = new int[14];
        for (int i = 0; i < 14; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
        }

        int bnp = N;
        int timing = N;

        int bnpGet = 0;
        int timingGet = 0;
        int temp = 0;
        int price = chart[0];
        for (int i = 0; i < 14; i++) {
            if (bnp / chart[i] != 0) {
                bnpGet += bnp / chart[i];
                bnp = bnp % chart[i];
            }

            if (temp == 3) {
                timing += (timingGet * chart[i]);
                temp = 0;
            } else if (temp == -3) {
                if (timing / chart[i] != 0) {
                    timingGet += timing / chart[i];
                    timing = timing % chart[i];
                }
            } else {
                if (temp == 0) {
                    if (price > chart[i]) {
                        temp--;
                    } else if (price < chart[i]) {
                        temp++;
                    }
                } else if (temp > 0) {
                    if (price > chart[i]) {
                        temp = -1;
                    } else if (price < chart[i]) {
                        temp++;
                    } else {
                        temp = 0;
                    }
                } else if (temp < 0) {
                    if (price > chart[i]) {
                        temp--;
                    } else if (price < chart[i]) {
                        temp = 1;
                    } else {
                        temp = 0;
                    }
                }
            }
            price = chart[i];
        }

        bnp += bnpGet * chart[13];
        timing += timingGet * chart[13];
        if (bnp > timing) {
            System.out.println("BNP");
        } else if (bnp < timing) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

        br.close();
    }

}