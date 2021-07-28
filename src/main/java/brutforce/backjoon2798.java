package brutforce;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon2798 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int max=0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int a = 0; a < n-2; a++) {
            for (int b = a+1; b < n-1; b++) {
                for (int c = b+1; c < n; c++) {
                    if(arr[a]+arr[b]+arr[c] <= m){
                        if(arr[a]+arr[b]+arr[c] > max){
                            max = arr[a]+arr[b]+arr[c];
                        }
                    }
                }
            }
        }
        System.out.println("max = " + max);

    }
}
