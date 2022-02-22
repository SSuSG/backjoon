package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon1920 {
    static int n,m;
    static int arr1[];
    static int arr2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        for (int i = 0; i < m; i++) {
            if(binarySearch(arr2[i] , 0, n-1))
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        System.out.println(sb);


    }

    private static boolean binarySearch(int key , int low , int high) {
        int mid;

        if(low <= high){
            mid = (high + low)/2;

            if(key == arr1[mid]){
                return true;
            }else if(key < arr1[mid]){
                return binarySearch(key , low , mid-1);
            }else{
                return binarySearch(key , mid+1 , high);
            }
        }
        return false;

    }
}
