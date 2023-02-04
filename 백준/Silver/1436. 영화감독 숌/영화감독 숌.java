import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int tripleSix = 666;
        while (N > 0) {
            String temp = "" + tripleSix++;

            if (temp.contains("666")) {
                N--;
            }
            if (N == 0)
                System.out.println(temp);
        }

        br.close();

    }


}