package swea;
import java.util.*;

public class d4_1226_미로1 {
    static int[][] dirs = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    static boolean[][] visited;
    static int canGoal;

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            for(int tc = 1; tc <= 10; tc++) {
                int t = sc.nextInt();
                canGoal = 0;

                int[][] map = new int[16][16];

                for (int i = 0; i < 16; i++) {
                    String input = sc.next();
                    for (int j = 0; j < 16 ;  j++) {
                        map[i][j] = input.charAt(j) - '0';
                    }
                }

                Queue<int[]> q = new LinkedList<>();
                visited = new boolean[16][16];
                q.add(new int[] {1,1});
                visited[1][1] = true;

                while(!q.isEmpty()) {
                    int[] point = q.poll();


                    for (int[] dir : dirs) {
                        int ny = dir[0] + point[0];
                        int nx = dir[1] + point[1];

                        if(nx >= 0 && ny >= 0 && nx < 16 && ny < 16 && map[ny][nx] != 1 && visited[ny][nx] == false) {
                            if(map[ny][nx] == 3) {

                                canGoal = 1;
                                break;
                            }

                            q.add(new int[] {ny,nx});
                            visited[ny][nx] = true;
                            }
                        }

                        if(canGoal == 1)
                            break;
                }

                System.out.println("#" + t + " " + canGoal);
            }
    }
}
