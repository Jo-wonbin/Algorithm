import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int arr[];
    static boolean visited[];
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");

        for (int temp : list) {
            sb.append(temp).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int des, int now) {
        if (des == now) {
            list.add(des);
            return;
        }

        if (!visited[now]) {
            visited[now] = true;
            dfs(des, arr[now]);
            visited[now] = false;
        }
    }


}