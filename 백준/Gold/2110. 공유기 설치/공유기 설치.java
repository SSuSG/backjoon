import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
        int high = arr[n-1] - arr[0] +1;

        while(low < high){
            int mid =(low+high)/2;

            if(canInstall(mid) < c){
                high = mid;
            }else{
                low = mid+1;
            }

        }
        System.out.println(low-1);

    }

    private static int canInstall(int distance) {
        int count = 1;
        int lastLocate = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if(arr[i] - lastLocate >= distance){
                count++;
                lastLocate = arr[i];
            }

        }
        return count;
    }
}