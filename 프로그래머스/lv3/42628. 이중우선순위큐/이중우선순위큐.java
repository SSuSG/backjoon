import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>( (o1,o2) -> o1-o2);
        //내림차순
        PriorityQueue<Integer> rpq = new PriorityQueue<>( (o1,o2) -> o2-o1);
        
        for(String temp : operations){
            String[] command = temp.split(" ");
            //데이터 삽입
            if(command[0].equals("I")){
                int num = Integer.parseInt(command[1]);
                rpq.add(num);
                pq.add(num);
            }else{
                //데이터 삭제
                if(pq.size() < 1) continue;
                
                if(command[1].equals("1")){
                    int removeNum = rpq.poll();
                    pq.remove(removeNum);
                }else{
                    int removeNum = pq.poll();
                    rpq.remove(removeNum); 
                }
            }
        
        }
        if(pq.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = rpq.poll();
            answer[1] = pq.poll();
        }
       
        return answer;
    }
}