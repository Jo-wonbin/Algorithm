import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        boolean[][] visited = new boolean[7][7];
        String start = br.readLine();
        int x = start.charAt(0) - 'A' + 1;
        int y = start.charAt(1) - '0';
        visited[x][y] = true;
        boolean flag = true;
        int nx = 0;
        int bx = x;
        int ny = 0;
        int by = y;
        while (cnt++ < 35) {

            String temp = br.readLine();
            nx = temp.charAt(0) - 'A' + 1;
            ny = temp.charAt(1) - '0';

            if (visited[nx][ny]) {
                flag = false;
            }

            if (!((Math.abs(nx - bx) == 1 && Math.abs(ny - by) == 2) || (Math.abs(nx - bx) == 2 && Math.abs(ny - by) == 1))) {
                flag = false;
            }

            visited[nx][ny] = true;
            bx = nx;
            by = ny;
        }

        if (!((Math.abs(nx - x) == 1 && Math.abs(ny - y) == 2) || (Math.abs(nx - x) == 2 && Math.abs(ny - y) == 1))) {
            flag = false;
        }

        if (flag) {
            System.out.println("Valid");
        } else
            System.out.println("Invalid");

        br.close();
    }

}