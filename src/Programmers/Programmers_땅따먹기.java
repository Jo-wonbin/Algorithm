package Programmers;

public class Programmers_땅따먹기 {

    class Solution {

        int solution(int[][] land) {

            int answer = 0;
            int[][] arr = new int[100001][4];

            for (int i = 0; i < 4; i++) {
                arr[1][i] = land[0][i];
            }

            System.out.println(land.length);
            int size = land.length;
            if (size > 1) {
                for (int i = 2; i <= size; i++) {

                    for (int j = 0; j < 4; j++) {
                        for (int h = 0; h < 4; h++) {
                            if (j == h)
                                continue;
                            arr[i][j] = Math.max(arr[i - 1][h] + land[i - 1][j], arr[i][j]);
                        }
                    }
                }
            }


            for (int i = 0; i < 4; i++) {
                answer = Math.max(arr[size][i], answer);
            }

            return answer;
        }
    }

}
