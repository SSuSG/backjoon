package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0 ; i < n ; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            arr[i] = str.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0;  i< n ; i++) {
            if (i >=1 && arr[i].equals(arr[i-1])){
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
