import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(key) - lowerBound(key)).append(' ');
        }
        System.out.println(sb);

    }

    private static int lowerBound(int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {

            int mid = (lo + hi) / 2; 

            if (key <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int key) {
        int lo = 0;
        int hi = arr.length;

        
        while (lo < hi) {

            int mid = (lo + hi) / 2; 

          
            if (key < arr[mid]) {
                hi = mid;
            }
            
            else {
                lo = mid + 1;
            }

        }

        return lo;
    }


}