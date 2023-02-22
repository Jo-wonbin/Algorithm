import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M, V;
    static ArrayList<Integer>[] PointList;
    static boolean visited[];
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        PointList = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            PointList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            PointList[first].add(second);
            PointList[second].add(first);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(PointList[i]);
        }

        visited = new boolean[N+1];
        visited[V] = true;
        sb.append(V).append(" ");
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

        br.close();

    }

    static void dfs(int start){
        for(int i=0; i<PointList[start].size(); i++){
            int temp = PointList[start].get(i);
            if(visited[temp])
                continue;
            visited[temp] = true;
            sb.append(temp).append(" ");
            dfs(temp);
        }
    }

    static void bfs(int start){
        
        q.add(start);
        visited[start] = true;
        sb.append(V).append(" ");
        
        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0; i<PointList[now].size(); i++){
                int temp = PointList[now].get(i);
                if(visited[temp])
                    continue;
                q.add(temp);
                visited[temp] = true;
                sb.append(temp).append(" ");
            }
        }
    }

}