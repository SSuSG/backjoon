import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        int[] result = new int[1450];
        int[][] book_time_new = new int[book_time.length][2];
        int max = 0;
        for(int i = 0 ; i < book_time.length ; i++){
            book_time_new[i][0] = calTime(book_time[i][0]);
            book_time_new[i][1] = calTime(book_time[i][1])+10;
        } 
        
        for(int i = 0 ; i < book_time.length ; i++){
            for(int j = book_time_new[i][0] ; j < book_time_new[i][1] ; j++){
                result[j]++;
                max = Math.max(max,result[j]);
            }
        }
        
        return max;
    }
    private static int calTime(String time){
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return ((Integer.parseInt(hour) * 60) + Integer.parseInt(minute));
    }
}