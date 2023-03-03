import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] tempMap;
    static boolean[][] visit;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //가로
        n = Integer.parseInt(st.nextToken()); //세로

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==1)
                    queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for (int[] dir : dirs) {
                int nrow = temp[0] + dir[0];
                int ncol = temp[1] + dir[1];

                if(nrow >= 0 && ncol >=0 && nrow < n && ncol < m && map[nrow][ncol] == 0){
                    map[nrow][ncol] = map[temp[0]][temp[1]] + 1;
                    queue.add(new int[]{nrow,ncol});
                }
            }
        }

        int day = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0)
                    return -1;

                if(day < map[i][j])
                    day = map[i][j];
            }
        }
        if(day == 0)
            return 0;
        else
            return day-1;

    }
}