import java.io.*;
import java.util.*;

public class Main {
    static int r,c,t;
    static List<Integer> airRobot = new ArrayList<>();
    static int[][] map;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 )
                    airRobot.add(i);
            }
        }

        for (int i = 0; i < t; i++) {
            //미세먼지 확산
            map = spread();

            //공기청정기 작동
            perform();
        }

        System.out.println(calc() + 2);
    }


    public static int[][] spread(){
        int[][] temp = new int[r][c];
        temp[airRobot.get(0)][0] = -1;
        temp[airRobot.get(1)][0] = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] > 0) {
                    int spreadSum = 0;
                    for (int[] dir : dirs) {
                        int ny = i + dir[0];
                        int nx = j + dir[1];

                        if(ny >= 0 & nx >= 0 && ny < r && nx < c && map[ny][nx] != -1) {
                            spreadSum += map[i][j]/5;
                            temp[ny][nx] += map[i][j]/5;
                        }
                    }
                    temp[i][j] += map[i][j] - spreadSum;
                }
            }
        }

        return temp;
    }


    public static void perform() {
        int high = airRobot.get(0);

        for (int y = high - 2; y >= 0; y--) {
            map[y+1][0] = map[y][0];
        }

        for (int x = 1; x < c ; x++) {
            map[0][x-1] = map[0][x];
        }

        for (int y = 1; y <= high ; y++) {
            map[y-1][c-1] = map[y][c-1];
        }

        for (int x = c-2; x > 0 ; x--) {
            map[high][x+1] = map[high][x];
        }

        map[high][1] = 0;

        int low = airRobot.get(1);

        for (int y = low+2 ; y < r ; y++) {
            map[y-1][0] = map[y][0];
        }

        for (int x = 1; x < c ; x++) {
            map[r-1][x-1] = map[r-1][x];
        }

        for (int y = r-2; y >= low ; y--) {
            map[y+1][c-1] = map[y][c-1];
        }

        for (int x = c-2; x > 0 ; x--) {
            map[low][x+1] = map[low][x];
        }

        map[low][1] = 0;
    }

    public static int calc(){
        int dustSum = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dustSum += map[i][j];
            }
        }

        return dustSum;
    }

}