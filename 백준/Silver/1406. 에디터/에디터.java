import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> list = new LinkedList<>();
        String temp = br.readLine();

        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);
            if (order == 'P') {
                iter.add(st.nextToken().charAt(0));
            } else if (order == 'L') {
                if (iter.hasPrevious()) iter.previous();
            } else if (order == 'D') {
                if (iter.hasNext()) iter.next();
            } else {
                if (iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Character letter : list) {
            bw.write(letter);
        }
        bw.flush();
        br.close();
    }

}