import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[] open;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1 ){
                    home.add(new Point(i,j));
                }else if(map[i][j] == 2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        open = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(ans);

    }

    private static void dfs(int depth, int cnt) {
        if(cnt == m){
            int sum = 0;

            for (int i = 0; i < home.size(); i++) {
                int dist = Integer.MAX_VALUE;
                
                for (int j = 0; j < chicken.size(); j++) {
                    if(open[j]){
                        
                        int temp = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        if(dist > temp)
                            dist = temp;
                    }
                }
                sum += dist;

            }
            if(sum < ans)
                ans = sum;
            return;
        }

        for (int i = depth; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i+1 , cnt+1);
            open[i] = false;
        }
    }
}
