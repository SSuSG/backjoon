import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] map;
    static int[][] copy;
    static int[] calc;
    static boolean[] isVisit;
    static int min = Integer.MAX_VALUE;
    static List<RotationCalc> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        isVisit = new boolean[k];

        for (int i = 1; i <= n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new RotationCalc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        calc = new int[list.size()];
        selectCalc(0);
        System.out.println(min);

    }

    public static void selectCalc(int depth) {
        if(depth == list.size()) {
            copy = new int[n+1][m+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            calc();

            int minRowSum = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= m; j++) {
                    sum += copy[i][j];
                }
                if(minRowSum > sum)
                    minRowSum = sum;
            }

            if(min > minRowSum)
                min = minRowSum;

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(isVisit[i])
                continue;

            isVisit[i] = true;
            calc[depth] = i;
            selectCalc(depth + 1);
            isVisit[i] =false;
        }
    }

    public static void calc() {
        for (int i = 0; i < calc.length; i++) {
            RotationCalc rotationCalc = list.get(calc[i]);
            int r = rotationCalc.r;
            int c = rotationCalc.c;

            for (int s = 1; s <= rotationCalc.s; s++) {
                int temp = copy[r-s][c-s];

                for (int y = r-s+1; y <= r+s; y++)
                    copy[y-1][c-s] = copy[y][c-s];

                for (int x = c-s+1; x <= c+s; x++)
                    copy[r+s][x-1] = copy[r+s][x];

                for (int y = r+s-1; y >= r-s; y--)
                    copy[y+1][c+s] = copy[y][c+s];

                for (int x = c+s-1; x >= c-s+1; x--)
                    copy[r-s][x+1] = copy[r-s][x];

                copy[r-s][c-s+1] = temp;
            }
        }

    }

    public static class RotationCalc {
        int r;
        int c;
        int s;

        public RotationCalc(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}