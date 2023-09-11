import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer[] = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> nonMixedCard = new ArrayList<>();
        int num = 1;
        while (num <= N) {
            nonMixedCard.add(num++);
        }

        ArrayList<Integer> firstMixedCard;
        ArrayList<Integer> lastMixedCard;

        int maxK = possibleMixing(N);

        for (int i = 1; i <= maxK; i++) {
            firstMixedCard = mixed2_K_ver2(i, N, (ArrayList<Integer>) nonMixedCard.clone());

            for (int j = 1; j <= maxK; j++) {
                lastMixedCard = mixed2_K_ver2(j, N, (ArrayList<Integer>) firstMixedCard.clone());
                boolean isEquals = true;
                for (int z = 0; z < N; z++) {
                    if (answer[z] != lastMixedCard.get(z)) {
                        isEquals = false;
                    }
                }
                if (isEquals) {
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

    private static ArrayList<Integer> mixed2_K_ver2(int K, int N, ArrayList<Integer> card) {

        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 1;
        int index = N - 1;
        result.add(card.get(N - 1));
        while (cnt <= K) {
            int mixedCardListSize = (int) Math.pow(2, cnt);
            for (int i = N - mixedCardListSize; i < index; i++) {
                result.add(card.get(i));
            }
            index = N - mixedCardListSize;
            cnt++;
        }
        for (int i = 0; i < index; i++) {
            result.add(card.get(i));
        }
        return result;
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