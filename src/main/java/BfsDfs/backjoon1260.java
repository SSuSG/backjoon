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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int j = 0; j < n + 1; j++) {
            Arrays.fill(map[j],0);
        }
        Arrays.fill(visit,false);

        for (int i = 0; i < m; i++) {
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);

    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");

            for (int j = 1; j < n + 1; j++) {
                if(map[temp][j] == 1 && visit[j]==false){
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }

    private static void dfs(int i) {
        visit[i] = true;
        System.out.print(i+" ");

        for (int j = 1 ; j < n+1 ; j++) {
            if(map[i][j] == 1 && visit[j] == false){
                dfs(j);
            }
        }
    }
}
