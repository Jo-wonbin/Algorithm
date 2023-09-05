import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> dodo = new LinkedList<>();
        Queue<Integer> suyeon = new LinkedList<>();

        ArrayList<Integer> groundOfDodo = new ArrayList<>();
        ArrayList<Integer> groundOfSuyeon = new ArrayList<>();

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st1.push(Integer.parseInt(st.nextToken()));
            st2.push(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            dodo.add(st1.pop());
            suyeon.add(st2.pop());
        }

        int topOfDodo = 0;
        int topOfSuyeon = 0;
        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                topOfDodo = dodo.poll();
                groundOfDodo.add(topOfDodo);
            } else {
                topOfSuyeon = suyeon.poll();
                groundOfSuyeon.add(topOfSuyeon);
            }

            if (dodo.isEmpty()) {
                System.out.println("su");
                return;
            }
            if (suyeon.isEmpty()) {
                System.out.println("do");
                return;
            }

            if (topOfDodo != 0 && topOfSuyeon != 0) {
                if (topOfDodo + topOfSuyeon == 5) {

                    groundOfDodo.forEach(suyeon::add);
                    groundOfDodo.clear();
                    groundOfSuyeon.forEach(suyeon::add);
                    groundOfSuyeon.clear();

                    topOfDodo = 0;
                    topOfSuyeon = 0;

                }
            }
            if (topOfDodo == 5 || topOfSuyeon == 5) {

                groundOfSuyeon.forEach(dodo::add);
                groundOfSuyeon.clear();
                groundOfDodo.forEach(dodo::add);
                groundOfDodo.clear();

                topOfDodo = 0;
                topOfSuyeon = 0;
            }

        }

        if (dodo.size() > suyeon.size()) {
            System.out.println("do");
        } else if (dodo.size() < suyeon.size()) {
            System.out.println("su");
        } else {
            System.out.println("dosu");
        }

        br.close();
    }

}