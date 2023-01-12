package swea;

import java.util.Scanner;

public class d2_1209_sum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();

            int[][] map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int sum = 0;

            //가로
            for (int i = 0; i < 100; i++) {
                sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[i][j];
                }
                if(max <= sum)
                    max = sum;
            }

            //세로
            for (int i = 0; i < 100; i++) {
                sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[j][i];
                }
                if(max <= sum)
                    max = sum;
            }

            sum = 0;
            //대각 왼 -> 오
            for (int i = 0; i < 100; i++) {
                sum += map[i][i];
            }

            if(max <= sum)
                max = sum;

            sum = 0;
            //대각 오 -> 왼
            for (int i = 99 , j = 0; i > 0; i-- , j++) {
                sum += map[j][i];
            }

            if(max <= sum)
                max = sum;

            System.out.println("#" + tc + " " + max);
        }
    }
}
