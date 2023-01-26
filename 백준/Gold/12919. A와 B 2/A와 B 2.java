import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static boolean result = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String start = br.readLine();


        find(start, target);

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


        br.close();
    }

    static void find(String start, String target) {
        if (start.length() == target.length()) {

            if (start.equals(target)) {
                result = true;
            }
            return;
        }

        if(result)
            return;

        if (start.charAt(start.length() - 1) == 'A') {
            find(start.substring(0, start.length() - 1), target);
        }

        if (start.charAt(0) == 'B') {
            String temp = start.substring(1);
            StringBuilder sb = new StringBuilder(temp);
            String temp2 = sb.reverse().toString();
            find(temp2, target);
        }
    }
}