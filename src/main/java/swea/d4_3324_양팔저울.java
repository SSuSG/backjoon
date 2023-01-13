package swea;

import java.util.Scanner;

public class d4_3324_양팔저울 {
    static int n;
    static boolean isVisit[];
    static int[] weightThing;
    static int[] output;
    static int result;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            weightThing = new int[n];
            output = new int[n];
            isVisit = new boolean[n];
            result = 0;

            for (int i = 0; i < n; i++) {
                weightThing[i] = sc.nextInt();
            }

            permutaion(0);

            System.out.println("#" + test_case + " " + result);
        }
    }

    public static void permutaion(int depth) {
        if(depth == n) {
            calc(0,0,0);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isVisit[i] != true) {
                output[depth] = weightThing[i];
                isVisit[i] = true;
                permutaion(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void calc(int cnt , int leftSum , int rightSum) {
        //오른쪽합이 왼쪽합 보다 클시 종료
        if(leftSum < rightSum)
            return;

        if(cnt == n){
            result++;
            return;
        }

        //왼쪽에 올릴때
        calc(cnt + 1 , leftSum + output[cnt] , rightSum);

        //오른쪽에 올릴때
        calc(cnt + 1 , leftSum , rightSum + output[cnt]);
    }
}
