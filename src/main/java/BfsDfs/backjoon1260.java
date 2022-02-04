package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon1260 {
    static int map[][];
    static boolean[] visit;
    static int n,m,v;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(v);
        sb.append('\n');
        Arrays.fill(visit, false);
        bfs(v);
        System.out.println(sb);

    }

    private static void dfs(int v ) {
        visit[v] = true;
        sb.append(v+" ");

        for (int i = 1 ; i <= n ; i++){
            if(map[v][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }

    }

    private static void bfs(int v ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;
        sb.append(v+" ");

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int i = 1 ; i <= n ; i++){
                if(map[temp][i] == 1 && visit[i] == false){
                    queue.add(i);
                    sb.append(i+" ");
                    visit[i] = true;
                }
            }

        }

    }


}
