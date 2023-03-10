import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] road;
    static long[] city;
    static long sum;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sum =0 ;

        road = new long[n-1]; //거리
        city = new long[n]; //비용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n-1; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = city[0];
        for (int i = 0; i < n-1; i++) {

            if(minCost > city[i]){
                minCost = city[i];
            }
            
            sum += minCost*road[i];
        }
        System.out.println(sum);

    }


}