package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon2110 {
    static int c,n;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int low = 1;
        int high = arr[n-1];
        int distance = 0;
        while(low < high){
            int mid = (low+high)/2;
            int start = arr[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                distance = arr[i] - start;
                if(distance >= mid){
                    cnt++;
                    start = arr[i];
                }
            }
            //설치한 공유기의수가 더 많을시 거리를 높여야한다.
            if(cnt >= c){
                low = mid+1;
            }else{
                //설치한 공유기의수가 더 적을시 거리를 줄여야한다.
                high = mid;
            }

        }
        System.out.println(low-1);
    }
}
