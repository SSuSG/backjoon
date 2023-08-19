import java.util.*;
class Solution {
    
    static HashMap<String , Integer> map;
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for(int i = 0 ; i < course.length ; i++){
            map = new HashMap<>();
            
            int max = 0;
            for(int j = 0 ; j < orders.length ; j++){
                 StringBuilder sb = new StringBuilder(); 
                if(course[i]<=orders[j].length())
                    comb(orders[j],sb,0,0,course[i]);    
            }
            
            for(String key : map.keySet()){
                max = Math.max(max , map.get(key));
            }
            
            for(String key : map.keySet()){
                if(max >= 2 && map.get(key) == max)
                    answer.add(key);
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    public void comb(String str , StringBuilder sb, int idx, int cnt, int n){
       if(cnt == n) {
           map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
           return;
        }
        
        for(int i = idx ; i<str.length();i++){
            sb.append(str.charAt(i));
            comb(str,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);
        }
    }
}