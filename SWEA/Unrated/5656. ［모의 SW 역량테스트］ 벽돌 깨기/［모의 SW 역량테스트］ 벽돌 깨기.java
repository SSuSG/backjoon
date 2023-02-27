import java.util.*;
import java.io.*;
public class Solution {
    static int n,w,h,min;
    static int[][] map;
    static int[] output;
    static int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("res/input_벽돌.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            output = new int[n];

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            //벽돌 날리기
            comb(0);
            sb.append("#" + tc + " " + min + "\n");
        }
        System.out.println(sb);
    }
    static void comb(int cnt){
        if(cnt == n){
            //값 복사
            int[][] copyMap = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                //x번째 열의 벽돌 공격
                int x = output[i];

                //벽돌 파괴
                for (int y = 0; y < h; y++) {
                    if(copyMap[y][x] > 0) {
                        shoot(x,y,copyMap);
                        break;
                    }
                }
                //벽돌 이동하기
                move(copyMap);
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(copyMap[i][j] > 0)
                        count++;
                }
            }
            min = Math.min(min, count);
            return;

        }
        for (int i = 0; i < w; i++) {
            output[cnt] = i;
            comb(cnt+1);
        }
    }


    static void move(int[][] tempMap) {
        for (int i = h-1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {
                if(tempMap[i][j] > 0) {
                    int y = i;
                    int ny = i+1;

                    while(ny < h && tempMap[y][j] > 0 && tempMap[ny][j] == 0) {
                        tempMap[ny][j] = tempMap[y][j];
                        tempMap[y][j] = 0;
                        y = ny;
                        ny++;
                    }
                }
            }
        }
    }

    static void shoot(int x,int y ,int[][] tempMap) {
        int cnt = tempMap[y][x];
        tempMap[y][x] = 0;

        for (int d = 0; d < 4; d++) {
            int ny = y;
            int nx = x;
            for (int i = 1; i < cnt; i++) {
                ny += dirs[d][0];
                nx += dirs[d][1];

                if(nx < 0 || ny < 0 || ny >= h || nx >= w)
                    break;
                if(tempMap[ny][nx] == 0)
                    continue;
                if(nx >= 0 && ny >= 0 && nx < w && ny < h && tempMap[ny][nx] > 1) {
                    shoot(nx,ny,tempMap);
                    continue;
                }
                tempMap[ny][nx] = 0;
            }
        }
    }
}
