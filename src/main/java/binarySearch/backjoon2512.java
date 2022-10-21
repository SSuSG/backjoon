package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon2512 {
    static int n,m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int max = 0 ;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
            if(max < arr[i])
                max = arr[i];
        }
        m = Integer.parseInt(br.readLine());

        int min = 0;

        while(min < max ){
            int mid = (max + min )/2;
            int sum = 0;

            for (int i : arr) {
                if(i >= mid){
                    sum += mid;
                }else{
                    sum += i;
                }
            }

            if(sum > m){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        System.out.println(min-1);



//        int min = 0;
//        max++;
//        while (min < max){
//            int mid = (min+max)/2;
//            int sum= 0;
//            for (int price : arr) {
//                //설정한 예산보다 더 많이 요청했을시 설정한 예산만큼만 준다.
//                if(mid < price){
//                    sum += mid;
//                }else{
//                    sum += price;
//                }
//            }
//            //나눠준 예산이 국가예산보다 적은경우 예산을 더 늘린다.
//            if(sum <= m )
//                min = mid+1;
//            else
//                max = mid;
//        }
//        System.out.println(min-1);

    }
}
