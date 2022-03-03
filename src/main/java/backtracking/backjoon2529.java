package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon2529 {
    static int k;
    static char[] arr;
    static List<String> list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visit = new boolean[10];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i <=9; i++) {
            visit[i] = true;
            bt(0,String.valueOf(i));
            visit[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    private static void bt(int depth ,String num) {
        if(depth == k){
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if(arr[depth] == '>'){
                if(!visit[i] && num.charAt(num.length()-1)-'0' > i){
                    visit[i] = true;
                    bt(depth+1 , num+i);
                    visit[i] = false;
                }
                
            }else if(arr[depth] == '<'){
                if(!visit[i] && num.charAt(num.length()-1)-'0' < i){
                    visit[i] = true;
                    bt(depth+1, num+i);
                    visit[i] = false;
                }
            }
        }
        
        
    }
}
