package swea;

import java.util.Scanner;
import java.io.FileInputStream;

public class d2_1974_스도쿠검증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int answer = 1;
            int[][] map = new int[10][10];

            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i <= 9 ; i++) {
                if(checkRow(map,i) == 0) {
                    answer = 0 ;
                    break;
                }

                if(checkCol(map,i) == 0){
                    answer = 0 ;
                    break;
                }
            }

            for (int i = 1; i <= 7 ; i+=3) {
                for (int j = 1; j <= 7 ; j+=3) {
                    if(checkMiniMap(map,i,j) == 0){
                        answer = 0 ;
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    public static int checkRow(int[][] map , int checkRowNum){
        int[] checkMap = new int[10];

        for (int i = 1; i <= 9; i++) {
            checkMap[map[checkRowNum][i]]++;
        }

        for (int i = 1; i <= 9; i++) {
            if(checkMap[i] != 1)
                return 0;
        }
        return 1;
    }

    public static int checkCol(int[][] map , int checkColNum){
        int[] checkMap = new int[10];

        for (int i = 1; i <= 9; i++) {
            checkMap[map[i][checkColNum]]++;
        }

        for (int i = 1; i <= 9; i++) {
            if(checkMap[i] != 1)
                return 0;
        }
        return 1;
    }

    public static int checkMiniMap(int[][] map , int startRow , int startCol){
        int[] checkMap = new int[10];

        for (int i = startRow; i <= startRow+2; i++) {
            for (int j = startCol; j <= startCol+2; j++) {
                checkMap[map[i][j]]++;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if(checkMap[i] != 1)
                return 0;
        }
        return 1;
    }
}
