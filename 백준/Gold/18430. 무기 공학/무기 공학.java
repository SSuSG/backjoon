import java.util.*;
import java.io.*;
public class Main {
    static int n,m,max=0;
    static int[][] map;
    static boolean[][] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);
        System.out.println(max);
    }

    static void dfs(int x, int y , int sum){
        if(x == m){
            x = 0;
            y = y+1;
        }

        if(y == n){
            max = Math.max(max,sum);
            return;
        }

        if(isArea(x-1,y) && isArea(x,y) && isArea(x,y+1) && !isVisit[y][x-1] && !isVisit[y][x] && !isVisit[y+1][x]){
            isVisit[y][x-1] = isVisit[y][x] = isVisit[y+1][x] = true;
            dfs(x+1,y, sum + map[y][x-1] + map[y+1][x] + map[y][x]*2);
            isVisit[y][x-1] = isVisit[y][x] = isVisit[y+1][x] = false;
        }
        if(isArea(x-1,y) && isArea(x,y) && isArea(x,y-1) && !isVisit[y][x-1] && !isVisit[y][x] && !isVisit[y-1][x]){
            isVisit[y][x-1] = isVisit[y][x] = isVisit[y-1][x] = true;
            dfs(x+1,y, sum + map[y][x-1] + map[y-1][x] + map[y][x]*2);
            isVisit[y][x-1] = isVisit[y][x] = isVisit[y-1][x] = false;
        }
        if(isArea(x,y-1) && isArea(x,y) && isArea(x+1,y) && !isVisit[y-1][x] && !isVisit[y][x] && !isVisit[y][x+1]){
            isVisit[y-1][x] = isVisit[y][x] = isVisit[y][x+1] = true;
            dfs(x+1,y, sum + map[y-1][x] + map[y][x+1] + map[y][x]*2);
            isVisit[y-1][x] = isVisit[y][x] = isVisit[y][x+1] = false;
        }
        if(isArea(x,y+1) && isArea(x,y) && isArea(x+1,y) && !isVisit[y+1][x] && !isVisit[y][x] && !isVisit[y][x+1]){
            isVisit[y+1][x] = isVisit[y][x] = isVisit[y][x+1] = true;
            dfs(x+1,y, sum + map[y+1][x] + map[y][x+1] + map[y][x]*2);
            isVisit[y+1][x] = isVisit[y][x] = isVisit[y][x+1] = false;
        }
        dfs(x+1,y,sum);
    }

    static boolean isArea(int x, int y){
        if(x < 0 || y < 0 || x >= m || y >= n)
            return false;
        return true;
    }
}