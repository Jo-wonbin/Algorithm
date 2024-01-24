import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int nums[] = new int[N];
        int result[] = new int[N];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }


        int cnt = 1;
        int index = 0;
        Queue<Character> q = new LinkedList<>();
        while (index < N && cnt <= N) {
            if (stack.isEmpty() || stack.peek() != nums[index]) {
                stack.push(cnt++);
                q.add('+');
            } else {
                stack.pop();
                q.add('-');
                index++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == nums[index]) {
            q.add('-');
            stack.pop();
            index++;
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }


}