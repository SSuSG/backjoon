package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backjoon15649 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        List<Integer> tempList = new ArrayList<>();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        backtracking(tempList,arr);
        System.out.println(sb);

    }
    private static void backtracking(List<Integer> tempList, int[] arr){
        if(tempList.size() == m ){
            for (Integer integer : tempList) {
                sb.append(integer+" ");
            }
            sb.append("\n");
        }else{
            for (int i = 1 ; i <= n; i++) {
                if(tempList.contains(arr[i]))
                    continue;
                tempList.add(arr[i]);
                backtracking(tempList, arr);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
