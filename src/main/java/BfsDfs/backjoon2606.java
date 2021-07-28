package BfsDfs;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon2606 {

    static int[][] map;
    static boolean[] visit;
    static int count =0;
    static int n ,s;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        Arrays.fill(visit , false);

        for (int i = 0; i < s; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for (int j = 1; j < n+1; j++) {
                if(map[temp][j] == 1 && visit[j] == false){
                    queue.offer(j);
                    count++;
                    visit[j] = true;
                }
            }
        }
    }

    private static void dfs(int i) {
        visit[i] = true;
        count++;
        for (int j = 0; j < n+1; j++) {
            if(map[i][j] == 1 && visit[j] == false ){
                dfs(j);
            }
        }
    }
}
