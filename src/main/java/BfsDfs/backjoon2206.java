package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon2206 {
    static int n,m;
    static int arr[][];
    static Boolean visit[][][];
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
            {0,0}
    };

    static class Point{
        int x,y,distance;
        int chance;

        public Point(int x, int y, int distance, int chance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.chance = chance; //0 - > 벽 부순적 없음 , 1 -> 벽 부순적있음
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visit = new Boolean[n+1][m+1][2]; //0 -> 벽을 안부순 상태 , 1 -> 벽을 부순 상태

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j-1)-'0';
                Arrays.fill(visit[i][j],false);
            }
        }
        int result = bfs(1, 1);
        System.out.println(result);

    }
    private static int bfs(int i , int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i,j,1,0));
        visit[i][j][0] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();

            if(temp.x == n && temp.y == m){
                if(temp.x == 1 & temp.y ==1){
                    return 1;
                }
                return temp.distance;
            }

            for (int[] dir : dirs) {
                int x = temp.x + dir[0];
                int y = temp.y + dir[1];

                if(x >= 1 && y >= 1 && x <= n && y <=m){
                    if(arr[x][y] == 1){ //벽이 있는데
                        if(temp.chance == 0 && visit[x][y][1] == false){
                            visit[x][y][1] = true;
                            queue.offer(new Point(x,y,temp.distance+1,1));
                        }
                    }else{ // 벽이 없는데
                        if(visit[x][y][temp.chance] == false){
                            visit[x][y][temp.chance] = true;
                            queue.offer(new Point(x,y,temp.distance+1,temp.chance));
                        }
                    }
                    /*
                    if(temp.chance == 0){ // 벽을 부순적이 없고
                        if(arr[x][y] == 1 && visit[x][y][1] == false){ //벽이 있으면
                            visit[x][y][1] = true;
                            queue.offer(new Point(x,y,temp.distance+1,1));
                        }else if(visit[x][y][0] == false){ //벽이 없으면
                            visit[x][y][0] = true;
                            queue.offer(new Point(x,y,temp.distance+1,0));
                        }
                    }else{ //벽을 부순적이 있으면
                        if(arr[x][y] == 0 && visit[x][y][1] == false){
                            visit[x][y][1] = true;
                            queue.offer(new Point(x,y,temp.distance+1,1));
                        }
                    }*/
                }
            }
        }
        return -1;
    }
}
