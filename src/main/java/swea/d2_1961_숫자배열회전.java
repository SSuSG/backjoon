package swea;

import java.util.Scanner;

public class d2_1961_숫자배열회전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            int[][] result_90 = rotation(map);
            int[][] result_180 = rotation(result_90);
            int[][] result_270 = rotation(result_180);

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println(result_90[i][j]);
                }
                System.out.println(" ");

                for (int j = 0; j < n; j++) {
                    System.out.println(result_180[i][j]);
                }
                System.out.println(" ");

                for (int j = 0; j < n; j++) {
                    System.out.println(result_270[i][j]);
                }
                System.out.println(" ");
            }

        }
    }

    public static int[][] rotation(int[][] map){
        int[][] result = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                result[i][j] = map[map.length-j-1][i];
            }
        }

        return result;
    }
}
