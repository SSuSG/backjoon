package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon7562 {
    static int[][] map;
    static boolean[][] visit;
    static int l;
    static int[][] dirs = {
            {-2,-1},
            {-1,-2},
            {-2,1},
            {-1,2},
            {1,-2},
            {2,-1},
            {2,1},
            {1,2}
    };

    static class Point{
        int x;
        int y;
        int distance;

        public Point(int x, int y,int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static Point start;
    static Point result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int x,y;

        for (int i = 0; i < t; i++) {
            st =new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            map = new int[l][l];
            visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            start = new Point(x,y,0);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            result = new Point(x,y,0);

            int ans = bfs();
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();

            if(temp.x == result.x && temp.y == result.y)
                return temp.distance;

            for (int[] dir : dirs) {
                int x = temp.x + dir[0];
                int y = temp.y + dir[1];

                if(x >= 0 && y >= 0 && x < l && y<l && visit[x][y] == false){
                    queue.offer(new Point(x,y, temp.distance+1));
                    visit[x][y] = true;
                }
            }
        }

        return 0;
    }
}
