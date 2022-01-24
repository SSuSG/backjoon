package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon1759 {
    static int l,c;
    static char[] arr,result;
    static StringBuilder sb;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        l = sc.nextInt();
        c = sc.nextInt();
        result = new char[l];
        arr = new char[c];
        for (int i = 0 ; i < c ; i++){
            arr[i] = sc.next().charAt(0);
        }
        visit = new boolean[c];
        Arrays.sort(arr);
        dfs(0 , 0);
        System.out.println(sb);
    }

    private static void dfs(int depth , int at) {
        if(depth == l){
            int m =0;
            int z =0;
            for (char c1 : result) {
                if(c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 =='o' || c1=='u'){
                    m++;
                }else{
                    z++;
                }
            }
            if(m >=1 && z >=2){
                for (char c1 : result) {
                    sb.append(c1);
                }
                sb.append('\n');
            }

            return;
        }

        for (int i = at ; i < c ; i++){
            if(visit[i] == false){
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth+1 , i+1);
                visit[i] = false;
            }
        }
    }
}
