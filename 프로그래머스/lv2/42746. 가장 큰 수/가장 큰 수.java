import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        String[] arr = new String[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr , new Comparator<String>(){
            @Override
            public int compare(String s1 , String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });
        if(arr[n-1].equals("0"))
            return "0";
        
        for(int i = n-1 ; i >= 0 ; i--){
            answer+=arr[i];
        }  
        
        return answer;
    }
}