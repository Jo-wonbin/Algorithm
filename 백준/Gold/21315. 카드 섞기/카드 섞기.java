import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> nonMixedCard = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer[] = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;
        while (num <= N) {
            nonMixedCard.add(num++);
        }

        ArrayList<Integer> firstMixedCard;
        ArrayList<Integer> lastMixedCard;

        int maxK = possibleMixing(N);

        for (int i = 1; i <= maxK; i++) {
            firstMixedCard = mixed2_K(i, N, (ArrayList<Integer>) nonMixedCard.clone());

            for (int j = 1; j <= maxK; j++) {
                lastMixedCard = mixed2_K(j, N, (ArrayList<Integer>) firstMixedCard.clone());
                boolean flag = true;
                for (int z = 0; z < N; z++) {
                    if (answer[z] != lastMixedCard.get(z)) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }


        br.close();
    }

    private static int possibleMixing(int N) {
        int cnt = 9;
        while (cnt >= 1) {
            if (Math.pow(2, cnt) <= N)
                return cnt;
            cnt--;
        }
        return cnt;
    }

    private static ArrayList<Integer> mixed2_K(int K, int N, ArrayList<Integer> card) {

        ArrayList<Integer> result = new ArrayList<>();
        int mixedCardListSize = (int) Math.pow(2, K);
        for (int i = N - mixedCardListSize - 1; i >= 0; i--) {
            result.add(card.get(i));
        }
        int index = N - mixedCardListSize;

        while (K >= 0) {

            mixedCardListSize = (int) Math.pow(2, K);


            for (int i = index + mixedCardListSize / 2 - 1; i >= index; i--) {
                result.add(card.get(i));
            }
            index += mixedCardListSize / 2;
            K--;
        }
        result.add(card.get(index));
        Collections.reverse(result);
        return result;
    }
}