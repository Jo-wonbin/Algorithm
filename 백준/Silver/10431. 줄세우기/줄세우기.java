import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");

            ArrayList<Integer> list = new ArrayList<>();
            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                int temp = Integer.parseInt(st.nextToken());

                boolean flag = true;
                for (int h = 0; h < list.size(); h++) {
                    if (temp < list.get(h)) {
                        cnt += list.size() - h;
                        list.add(h, temp);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(temp);
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}