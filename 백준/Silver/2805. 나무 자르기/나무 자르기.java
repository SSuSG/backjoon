import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int min = 0;
        int max = tree[n-1]+1;
        int mid =0;
        while (min < max ){
            mid = (min+max)/2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                if(mid < tree[i])
                    count += tree[i] - mid;
            }

            if(count >= m )
                min = mid+1;
            else
                max = mid;

        }
        System.out.println(min-1);
    }
}