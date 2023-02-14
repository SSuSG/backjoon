import java.util.*;
import java.io.*;

public class Main {
    static int[][] topni = new int[5][8];
    static boolean[] isVisit;
    //회전시킨 톱니의 번호 , 회전시킬 방향 => 1 : 시계 , -1 : 반시계
    static Rotation[] rotation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 4; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < 8; j++) {
                topni[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        rotation = new Rotation[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotation[i] = new Rotation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < k; i++) {
            isVisit = new boolean[5];
            rotateTopni(rotation[i].topniNum, rotation[i].dir);
        }

        calcResult();
    }

    public static void rotateTopni(int topniNum , int rotateDir) {
        if(isVisit[topniNum])
            return;

        isVisit[topniNum] = true;

        int[] topniArrBeforeRotate = Arrays.copyOf(topni[topniNum], 8);
        int[] topniArrAfterRotate = new int[8];

        //시계방향 회전
        if(rotateDir == 1) {
            //System.out.println(topniNum + " 시계방향 회전");
            topniArrAfterRotate[0] = topni[topniNum][7];
            for (int i = 1; i < 8; i++) {
                topniArrAfterRotate[i] = topni[topniNum][i-1];
            }
        }

        //반시계방향 회전
        if(rotateDir == -1) {
            //System.out.println(topniNum + " 반시계방향 회전");
            topniArrAfterRotate[7] = topni[topniNum][0];
            for (int i = 0;	 i < 7 ; i++) {
                topniArrAfterRotate[i] = topni[topniNum][i+1];
            }
        }

        topni[topniNum] = topniArrAfterRotate;

        if(topniNum == 1) {
            if(topniArrBeforeRotate[2] != topni[topniNum+1][6]) {
                rotateTopni(topniNum+1, rotateDir == 1 ? -1 : 1);
            }
        }else if(topniNum == 4) {
            if(topniArrBeforeRotate[6] != topni[topniNum-1][2]) {
                rotateTopni(topniNum-1, rotateDir == 1 ? -1 : 1);
            }
        }else if(topniNum == 2 || topniNum == 3){

            //오른쪽
            if(topniArrBeforeRotate[2] != topni[topniNum+1][6]) {
                rotateTopni(topniNum+1, rotateDir == 1 ? -1 : 1);
            }

            //왼쪽
            if(topniArrBeforeRotate[6] != topni[topniNum-1][2]) {
                rotateTopni(topniNum-1, rotateDir == 1 ? -1 : 1);
            }
        }
    }

    public static void calcResult() {
        int sum = 0;
        if(topni[1][0] == 1)
            sum += 1;

        if(topni[2][0] == 1)
            sum += 2;

        if(topni[3][0] == 1)
            sum += 4;

        if(topni[4][0] == 1)
            sum += 8;

        System.out.println(sum);
    }

    public static class Rotation{
        int topniNum;
        int dir;

        public Rotation(int topniNum, int dir) {
            this.topniNum = topniNum;
            this.dir = dir;
        }

    }
}