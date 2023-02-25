import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static List<Integer>[] list;
    static boolean[] isVisit;
    static boolean isValid = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            isVisit = new boolean[n];
            isVisit[i] = true;
            for (Integer k : list[i]) {
                if(!isVisit[k])
                    solve(k,1);
            }
        }
        System.out.println(isValid ? 1 : 0);
    }

    static void solve(int to,int cnt) {
        isVisit[to] = true;
        if(isValid) return;
        if(cnt == 4) {
            isValid = true;
            return;
        }

        for (Integer t : list[to]) {
            if(!isVisit[t])
                solve(t, cnt + 1);
        }
        isVisit[to] = false;
    }
}