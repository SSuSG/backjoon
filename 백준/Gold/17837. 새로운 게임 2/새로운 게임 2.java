import java.io.*;
import java.util.*;

class Horse{
    int r;
    int c;
    int d;
    int num;

    public Horse(int r, int c, int d , int num) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.num = num;
    }
}

public class Main {
    static int n,k;
    static int[][] map;
    static int turn = 0;
    static List<Horse> list = new ArrayList<>();
    static ArrayList<Integer>[][] horseNumList;
    static int[][] dirs = {
            {0,1},
            {0,-1},
            {-1,0},
            {1,0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        horseNumList = new ArrayList[n+1][n+1];
        //0 흰
        //1 빨
        //2 파
        map = new int[n+1][n+1];

        for (int i = 1; i <= n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horseNumList[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Horse(y,x,d-1,i+1));
            horseNumList[y][x].add(i+1);
        }

        while(turn <= 1000) {
            //말을 순서대로 움직인다.
            if(move()) {
                System.out.println(turn);
                return;
            }
        }
        System.out.println(-1);

    }

    static boolean move() {
        turn++;

        for (int i = 0; i < list.size(); i++) {
            Horse nowHorse = list.get(i);
            int nowR = nowHorse.r;
            int nowC = nowHorse.c;
            int nowD = nowHorse.d;
            int nowSize = horseNumList[nowR][nowC].size();
            int ny = nowR + dirs[nowD][0];
            int nx = nowC + dirs[nowD][1];
            int nowHorseIdx = 0;
            
            for (int j = 0; j < nowSize; j++) {
                if(horseNumList[nowR][nowC].get(j) == nowHorse.num)
                    nowHorseIdx = j;
            }

            if(ny > 0 && nx > 0 && nx <= n && ny <= n && (map[ny][nx] == 0 || map[ny][nx] == 1) ) {

                //다음칸 흰색
                if(map[ny][nx] == 0) {
                    for (int j = nowHorseIdx; j < nowSize; j++) {
                        Horse horse = list.get(horseNumList[nowR][nowC].get(j)-1);
                        horse.r = ny;
                        horse.c = nx;
                        horseNumList[ny][nx].add(horse.num);
                    }
                }else{

                    //다음칸 빨강
                    for (int j = nowSize-1 ; j >= nowHorseIdx ; j--) {
                        Horse horse = list.get(horseNumList[nowR][nowC].get(j) - 1);
                        horse.r = ny;
                        horse.c = nx;
                        horseNumList[ny][nx].add(horse.num);
                    }
                }

                for (int j = nowSize-1; j >= nowHorseIdx; j--) {
                    horseNumList[nowR][nowC].remove(j);
                }
                
                //이동한 칸의 말이 4개 이상일 경우 종료
                if(horseNumList[ny][nx].size() >= 4)
                    return true;

            }else{      //범위 벗어나거나 or 파란색
                if(nowD == 0)
                    nowHorse.d = 1;
                else if(nowD == 1)
                    nowHorse.d = 0;
                else if(nowD == 2)
                    nowHorse.d = 3;
                else if(nowD == 3)
                    nowHorse.d = 2;

                ny = nowR + dirs[nowHorse.d][0];
                nx = nowC + dirs[nowHorse.d][1];

                if(ny > 0 && nx > 0 && ny <= n && nx <= n){
                    if(map[ny][nx] == 2)
                        continue;
                    else{
                        i--;
                        continue;
                    }
                }

            }

        }
        return false;
    }
}