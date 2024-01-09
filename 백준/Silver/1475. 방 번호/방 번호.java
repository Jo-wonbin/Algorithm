import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String roomNumber = br.readLine();

        int[] numberList = new int[10];

        for (int i = 0; i < roomNumber.length(); i++) {
            int temp = roomNumber.charAt(i) - '0';
            numberList[temp]++;
        }
        int max = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 6 || i == 9)
                continue;
            max = Math.max(max, numberList[i]);
        }

        max = Math.max(max, (numberList[6] + numberList[9]) % 2 == 0 ? (numberList[6] + numberList[9]) / 2 : (numberList[6] + numberList[9]) / 2 + 1);

        System.out.println(max);

        br.close();
    }
}