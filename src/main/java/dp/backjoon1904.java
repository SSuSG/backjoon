package dp;

import java.util.Scanner;

public class backjoon1904 {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n+1];

        int result = fibo(n);
        System.out.println(result);
    }

    private static int fibo(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n+1; i++) {
            arr[i] = ((arr[i-1])+(arr[i-2]))%15746;
        }
        return arr[n];
    }
}
