package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon2667 {
    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Integer> a;
    static int n , result;
    static StringBuilder sb;

    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result =0;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        a = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 &&  !visit[i][j]){
                    bfs(i,j);
                    result++;
                }
            }
        }
        Collections.sort(a);
        System.out.println(result);
        for (Integer integer : a) {
            System.out.println(integer);
        }

    }

    private static void bfs(int i, int j) {
        visit[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        int aptNum = 1;
        queue.offer(new int[]{i,j});

        while (!queue.isEmpty()){
            int[] temp = queue.poll();

            for (int[] dir : dirs) {
                int nx = temp[0] + dir[0];
                int ny = temp[1] + dir[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    aptNum++;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        a.add(aptNum);
    }
}
