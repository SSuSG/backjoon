import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static boolean doIt;
    static char[][] map;
    static boolean[][] isVisit;
    static List<Point> teachers = new ArrayList<>();
    static int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        isVisit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T')
                    teachers.add(new Point(j,i));
            }
        }
        //조합으로 장애물을 놓을수 있는곳 선택 , 3곳이 되면 bfs로 선생이 학생 감시 못하는지 확인
        selectObstacle(0);

        if(doIt)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void selectObstacle(int cnt ){
        if(doIt)
            return;

        if(cnt == 3){
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    selectObstacle(cnt+1);
                    map[i][j] = 'X';
                }
            }
        }

    }

    static void bfs(){
        for (Point teacher : teachers) {
            for (int d = 0; d < 4; d++) {
                ArrayDeque<Point> q = new ArrayDeque<>();
                q.offer(teacher);
                while(!q.isEmpty()){
                    Point cur = q.poll();

                    int ny = cur.y + dirs[d][0];
                    int nx = cur.x + dirs[d][1];

                    if(!isArea(nx,ny))  continue;
                    if(map[ny][nx] == 'O') continue;
                    if(map[ny][nx] == 'S') return;

                    q.offer(new Point(nx,ny));
                }
            }
        }
        doIt = true;
    }

    static boolean isArea(int x, int y){
        if(x >= 0 && y >= 0 && x < n && y < n )
            return true;
        return false;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}