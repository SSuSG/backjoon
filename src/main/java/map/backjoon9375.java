package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjoon9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            int result = 1;
            HashMap<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < c; j++) {
                st = new StringTokenizer(br.readLine());
                String temp1 = st.nextToken();
                String temp2 = st.nextToken();

                map.put(temp2, map.getOrDefault(temp2 , 0)+1);
            }


            for (String key : map.keySet()) {
                int num = map.get(key);
                result *= (num+1);
            }

           sb.append(result-1+"\n");
        }
        System.out.println(sb);

    }
}
