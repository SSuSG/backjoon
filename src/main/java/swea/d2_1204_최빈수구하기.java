package swea;

import java.util.Scanner;

public class d2_1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int t = sc.nextInt();

            int[] number = new int[101];

            for (int i = 0; i < 1000; i++) {
                number[sc.nextInt()]++;
            }

            int max = 0;
            int maxNumber = 0;
            for (int i = 0; i < 101; i++) {
                if(max <= number[i]) {
                    max = number[i];
                    maxNumber = i;
                }
            }

            System.out.println("#" + tc + " " + maxNumber);
        }
    }
}
