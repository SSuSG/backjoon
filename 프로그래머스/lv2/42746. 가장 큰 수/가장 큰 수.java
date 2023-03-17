import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr , new Comparator<String>(){
            @Override
            public int compare(String s1 ,String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });
        for(int i = numbers.length-1 ; i >= 0 ; i--){
            answer += arr[i];
        }
        if(arr[numbers.length-1].equals("0")) 
            return "0";
        return answer;
    }
}