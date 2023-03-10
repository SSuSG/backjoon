import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + temp;
            max = Math.max(max,temp);
        }

        System.out.println(lowerBound(max,dp[n]));
    }

    static int lowerBound(int low ,int high) {
        while(low < high) {
            int mid = (low+high)/2;
            int key = getM(mid);

            if(key <= m) {
                high = mid;
            }else {
                low = mid+1;
            }

        }
        return low;
    }

    static int getM(int key) {
        int cnt= 0;
        int sp = 1;
        int ep = 1;
        while(true) {
            //System.out.println(sp + " " + ep);
            int temp = dp[ep] - dp[sp-1];
            if(key >= temp) {
                ep++;
            }else {
                cnt++;
                sp = ep;
            }

            if(ep > n)
                break;
        }

        return cnt+1;
    }
}