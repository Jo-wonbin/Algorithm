import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {

    static int N, result;
    static char[] numbers;
    static boolean[] visited;
    static Stack<Character> st = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String num = br.readLine();

        numbers = num.toCharArray();
        visited = new boolean[N];

        result = Integer.MIN_VALUE;

        if (N == 1) {
            System.out.println(numbers[0] - '0');
        } else if (N == 3) {
            char tp = numbers[1];
            if (tp == '+') {
                result = (numbers[0] - '0') + (numbers[2] - '0');
            } else if (tp == '-') {
                result = (numbers[0] - '0') - (numbers[2] - '0');
            } else if (tp == '*') {
                result = (numbers[0] - '0') * (numbers[2] - '0');
            } else {
                result = (numbers[0] - '0') / (numbers[2] - '0');
            }
            System.out.println(result);
        } else {

            for (int i = 0; i <= N / 4; i++) {
                comb(0, 2, i);
            }

            System.out.println(result);
        }

        br.close();

    }

    static void calculator() {
        // 괄호 계산
        int index = 0;
        while (index < N) {

            if (visited[index]) {
                int a = numbers[index] - '0';
                int b = numbers[index + 2] - '0';
                if (numbers[index + 1] == '+') {
                    q.add(a + b);
                } else if (numbers[index + 1] == '-') {
                    q.add(a - b);
                } else if (numbers[index + 1] == '*') {
                    q.add(a * b);
                } else {
                    q.add(a / b);
                }
            }
            index++;
        }

        // 모든 계산
        index = 1;
        int temp = numbers[0] - '0';
        while (index < N) {
            if (index % 2 == 0) {
                char tp = st.pop();

                int temp2;
                if (visited[index]) {
                    temp2 = q.poll();
                    index += 2;
                } else {
                    temp2 = numbers[index] - '0';
                }

                if (tp == '+') {
                    temp += temp2;
                } else if (tp == '-') {
                    temp -= temp2;
                } else if (tp == '*') {
                    temp *= temp2;
                } else {
                    temp /= temp2;
                }
            } else {
                st.push(numbers[index]);
            }
            index++;
        }

        result = Math.max(temp, result);

        st.clear();
        q.clear();
    }

    static void comb(int cnt, int now, int end) {
        if (cnt == end) {

            calculator();

            return;
        }

        for (int i = now; i <= N - 3; i += 2) {
            if (visited[i] || visited[i - 2])
                continue;
            visited[i] = true;
            comb(cnt + 1, i + 2, end);
            visited[i] = false;
        }
    }

}