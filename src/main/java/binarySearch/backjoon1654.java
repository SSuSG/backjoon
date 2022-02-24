package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon1654 {
    static int k,n;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        long max =0 ;
        // 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        long min = 0;
        long mid = 0;
        max++;

        while(min < max){
            mid = (max + min)/2;

            long count =0;

            for (int i = 0; i < k; i++) {
                count += (arr[i]/mid);
            }

            if(count < n){
                max = mid;
            }else{
                min = mid+1;
            }

        }
        System.out.println(min-1);


    }
}
