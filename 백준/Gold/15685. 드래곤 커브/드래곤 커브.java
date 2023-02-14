import java.io.*;
import java.util.*;

public class Main {
        static int n,result;
        static boolean[][] isVisit;
        static int[][] dirs = {
                {0,1},
                {-1,0},
                {0,-1},
                {1,0}
        };

        static List<Dragon> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        isVisit = new boolean[101][101];

        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            isVisit[y][x] = true;
            list.add(new Dragon(x,y,d,g));
        }

        //드래곤커브가 존재하는 격자 구하기
        for (int i = 0; i < list.size(); i++) {
            Dragon d = list.get(i);
            addGeneration(d,0);
        }

        //드래곤커브의 일부인 정사각형 갯수 구하기
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if(isVisit[i][j] && isVisit[i+1][j] && isVisit[i][j+1] && isVisit[i+1][j+1])
                    result++;
            }
        }
        System.out.println(result);
    }

    static void addGeneration(Dragon dragon , int nowGeneration){
       if(dragon.g == nowGeneration)
            return;

        dragon.initDirection();
        dragon.move();
        addGeneration(dragon ,nowGeneration+1);
    }

    static class Dragon{
        int x;
        int y;
        int d;
        int g;
        List<Integer> directions;
        int nowDirIdx;

        //현재 위치에서 방향에 따라 이동하기
        void move(){
            for (; nowDirIdx < directions.size(); nowDirIdx++) {
                int nowDir = directions.get(nowDirIdx);
                int ny = this.y + dirs[nowDir][0];
                int nx = this.x + dirs[nowDir][1];
                isVisit[ny][nx] = true;
                this.y = ny;
                this.x = nx;
            }
        }

        //이전 세대의 방향들을 참고하여 다음세대 방향 구하기
        void initDirection(){
            List<Integer> newDirList = new ArrayList<>();
            for (int i = directions.size()-1; i >= 0; i--) {
                int dir = directions.get(i) == 3 ? 0 : directions.get(i) + 1;
                newDirList.add(dir);
            }

            for (Integer dir : newDirList)
                directions.add(dir);
        }

        public Dragon(int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
            this.directions = new ArrayList<>();
            directions.add(d);
            this.nowDirIdx = 0;
            this.move();
        }
    }
}