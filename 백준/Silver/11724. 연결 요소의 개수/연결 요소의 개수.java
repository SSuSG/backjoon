import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n,m;
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        int answer = 0;
        for (int i = 0 ; i< m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 1 ; i <= n ; i ++){
            if(visit[i] == false){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int v) {
        visit[v] = true;

        for (int i = 1 ; i <= n ; i++){
            if(map[v][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }
}