package swea;

import java.util.Scanner;

public class d4_1247_최적경로 {

    static int clientNum;
    static Point company;
    static Point home;
    static Point[] client;
    static Point[] output;
    static boolean isVisit[];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++)
            {
                min = Integer.MAX_VALUE;
                clientNum = sc.nextInt();
                company = new Point(sc.nextInt() , sc.nextInt());
                home = new Point(sc.nextInt() , sc.nextInt());
                client = new Point[clientNum+1];
                output = new Point[clientNum+1];
                isVisit = new boolean[clientNum+1];

                for (int i = 1; i <= clientNum; i++) {
                    client[i] = new Point(sc.nextInt() , sc.nextInt());
                }

                permutation(1);

                System.out.println("#" + test_case + " " + min);
            }
        }
    }

    //방문할 고객의 순서
    public static void permutation(int depth){
        if(depth == clientNum+1){
            calc();
            return;
        }

        for (int i = 1; i <= clientNum; i++) {
            if(!isVisit[i]){
                output[depth] = client[i];
                isVisit[i] = true;
                permutation(depth + 1);
                isVisit[i] = false;
            }
        }

    }

    public static void calc(){
        int distanceSum = 0;

        //회사에서 첫번째집
        distanceSum += Math.abs(company.x-output[1].x) + Math.abs(company.y-output[1].y);

        for (int i = 1; i <= clientNum - 1  ; i++) {
            distanceSum += Math.abs(output[i].x-output[i+1].x) + Math.abs(output[i].y-output[i+1].y);
        }

        //마지막 집에서 내집
        distanceSum += Math.abs(home.x-output[clientNum].x) + Math.abs(home.y-output[clientNum].y);

        if(min > distanceSum)
            min = distanceSum;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
