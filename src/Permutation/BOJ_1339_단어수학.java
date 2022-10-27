package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1339_단어수학 {

    static int N;
    static int alpha[];
    static String voca[];
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        voca = new String[N];
        alpha = new int[26];
        for (int i = 0; i < N; i++) {
            voca[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {   // 자릿수만 계산하여 알바벳 배열에 합산
            int temp = (int) Math.pow(10, voca[i].length() - 1);
            for (int j = 0; j < voca[i].length(); j++) {
                alpha[(int) voca[i].charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha); // 오름차순 정렬
        int num = 9;

        answer = 0;

        for (int i = alpha.length - 1; i >= 0; i--) {   // 제일 큰 값부터 9~0 인덱스 주기
            if (alpha[i] == 0)
                break;
            answer += num * alpha[i];
            num--;
        }

        System.out.println(answer);
    }
}
