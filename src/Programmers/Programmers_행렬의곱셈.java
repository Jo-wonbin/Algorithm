package Programmers;

public class Programmers_행렬의곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {

            int m = arr1.length;
            int k = arr1[0].length;
            int n = arr2[0].length;

            int[][] answer = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = 0;
                    for (int h = 0; h < k; h++) {
                        temp += arr1[i][h] * arr2[h][j];
                    }
                    answer[i][j] = temp;
                }
            }

            return answer;
        }
    }
}
