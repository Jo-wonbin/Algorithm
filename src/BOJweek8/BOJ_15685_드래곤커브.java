package BOJweek8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {

    static int x, y, d, g;
    static boolean[][] curve;
    static int result;
    static final int RIGHT = 0;
    static final int UP = 1;
    static final int LEFT = 2;
    static final int DOWN = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        curve = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            draw(x, y, getDirection(d, g));
        }

        result = 0;

        for(int i=0; i< 100; i++){
            for(int j=0; j<100; j++){
                if(curve[i][j] && curve[i+1][j] && curve[i][j+1]&&curve[i+1][j+1]){
                    result++;
                }
            }
        }

        System.out.println(result);

        br.close();
    }

    private static List<Integer> getDirection(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }

        return directions;
    }

    private static void draw(int x, int y, List<Integer> directions) {
        curve[x][y] = true;
        for (int direction : directions) {
            switch (direction) {
                case RIGHT:
                    curve[++x][y] = true;
                    break;
                case UP:
                    curve[x][--y] = true;
                    break;
                case LEFT:
                    curve[--x][y] = true;
                    break;
                case DOWN:
                    curve[x][++y] = true;
                    break;
            }
        }
    }
}
