import java.util.*;
class Solution {
    static int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    static int[][][] dp;
    static int min = Integer.MAX_VALUE;
    public int solution(String numbers) {
        int answer = 0;
        dp = new int[numbers.length()+1][10][10];
        for(int i = 0 ; i <= numbers.length() ; i++){
            for(int j = 0 ; j < 10 ; j++){
                Arrays.fill(dp[i][j] , 987654321);
            }
        }
        dp[0][4][6] = 0;

        for(int cnt = 0 ; cnt < numbers.length() ; cnt++){
            int num = numbers.charAt(cnt) - '0';
            
            for(int l = 0 ; l < 10 ; l++){
                for(int r = 0 ; r < 10 ; r++){
                    int preValue = dp[cnt][l][r];
                    if(l == r || preValue == Integer.MAX_VALUE) continue;
                    
                    //왼쪽 손가락으로 움직이기
                    dp[cnt+1][num][r] = Math.min(dp[cnt+1][num][r] , preValue + cost[l][num]);

                    //오른 손가락으로 움직이기
                    dp[cnt+1][l][num] = Math.min(dp[cnt+1][l][num] , preValue + cost[num][r]);
                }
            }
        }
        for(int l = 0 ; l < 10 ; l++){
            for(int r = 0 ; r < 10 ; r++){
                min = Math.min(min , dp[numbers.length()][l][r]);
            }
        }
        
        return min;
    }
    

}