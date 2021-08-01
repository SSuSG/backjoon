package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon1707 {

    static int v,e;
    static int[][] map;
    static int[] color;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            color = new int[v+1];
            map = new int[v+1][v+1];
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());

                map[x][y]=1;
                map[y][x]=1;
            }

            for (int j = 1; j < v + 1; j++) {
                if(color[j]==0){
                    color[j]=1;
                    bfs(j);
                }
            }

            check();
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Integer temp = queue.poll();

            for (int i = 1; i < v+1; i++) {

                if(i == temp)
                    continue;

                if(map[temp][i] == 1 && color[i] == 0){
                    queue.offer(i);
                    if(color[temp]==-1){
                        color[i] = 1;
                    }else{
                        color[i] = -1;
                    }
                }
            }
        }
    }

    static void check(){
        for (int j = 1; j < v+1; j++) {
            for (int k = 1; k < v+1; k++) {
                if(j==k)
                    continue;

                if(map[j][k] ==1){
                    if(color[j] == color[k]){
                        sb.append("NO"+"\n");
                        return;
                    }

                }
            }
        }
        sb.append("YES"+"\n");
        return;
    }
}
