package brutforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon14502 {
    static int n,m,max;
    static int map[][];
    static int dirs[][] = {
            {-1,0},
            {0,-1},
            {1,0},
            {0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        map = new int[n][m];
        int chance = 3;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        one(3);

        System.out.println(max);

    }

    private static void one(int chance) {
        if(chance == 0 ){
            //바이러스로 물들이기
            virus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    one(chance-1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] virusMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusMap[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                while (!queue.isEmpty()){
                    int[] poll = queue.poll();
                    for (int[] dir : dirs) {
                        int x = poll[0] + dir[0];
                        int y = poll[1] + dir[1];
                        if(x >= 0 && y >= 0 && x < n && y < m ){
                            if(virusMap[x][y] == 0){
                                virusMap[x][y] = 2;
                                queue.add(new int[]{x,y});
                            }
                        }
                    }
                }
            }
        }

        //안전영역 크기 계산
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusMap[i][j] == 0)
                    temp++;
            }
        }
        if(max < temp)
            max = temp;
    }
}
