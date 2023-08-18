import java.util.*;
class Solution {
    
    static String[] arr;
    static List<String> list;

    public int solution(String word) {
        
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        dfs(word, "", 0);
        
        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void dfs(String word , String now , int cnt){
        list.add(now);
        
        if(cnt == 5) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            dfs(word, now + arr[i], cnt + 1);
        }
    }
}