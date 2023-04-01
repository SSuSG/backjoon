import java.io.*;
import java.util.*;
public class Main {
    static int[][] map,room;
    static boolean[][] isVisit;
    static int n,m,roomCnt=0,maxRoom1=0,maxRoom2=0;
    static List<Integer> roomAreaList = new ArrayList<>();
    static int[][] dirs = {
            {0,-1},
            {-1,0},
            {0,1},
            {1,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        room = new int[n][m];
        isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //이 성에 있는 방의 개수 -> bfs
        //가장 넓은 방의 넓이 -> bfs , max
        //하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
        //-> 넘버링
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!isVisit[i][j]) bfs(j,i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i+1 < n && room[i][j] != room[i+1][j]){
                    maxRoom2 = Math.max(maxRoom2 , roomAreaList.get(room[i][j]-1) + roomAreaList.get(room[i+1][j]-1));
                }

                if(j+1 < m && room[i][j] != room[i][j+1]){
                    maxRoom2 = Math.max(maxRoom2 , roomAreaList.get(room[i][j]-1) + roomAreaList.get(room[i][j+1]-1));
                }
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoom1);
        System.out.println(maxRoom2);
    }

    static void bfs(int x,int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y,x});
        roomCnt++;
        int roomArea = 1;
        isVisit[y][x] = true;
        room[y][x] = roomCnt;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            //4방향 돌아보면서 벽이 있는곳은 가지않는다.
            //서 , 북 , 동 , 남 순서
            for (int i = 0; i < 4; i++) {
                //특정 방향에 벽이 있는경우 그 방향으로는 못간다.
                //System.out.println(map[cur[0]][cur[1]] & (1 << i));
                if((map[cur[0]][cur[1]] & (1 << i) ) > 0) continue;
                int ny = cur[0] + dirs[i][0];
                int nx = cur[1] + dirs[i][1];
                if(isVisit[ny][nx]) continue;
                isVisit[ny][nx] = true;
                room[ny][nx] = roomCnt;
                roomArea++;
                q.offer(new int[]{ny,nx});
            }
        }
        roomAreaList.add(roomArea);
        maxRoom1 = Math.max(maxRoom1 , roomArea);
    }
}