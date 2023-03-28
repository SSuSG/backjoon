import java.util.*;
class Solution {
    static class file{
        int priority;
        int idx;
        
        public file(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int order = 1;
        LinkedList<file> files = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            files.add(new file(priorities[i] , i));
        }
        int[] result = new int[priorities.length];
        boolean flag = false;
        while(!files.isEmpty()){
            file temp = files.poll();

            for (int i = 0; i < files.size(); i++) {
                if(temp.priority < files.get(i).priority){
                    files.offer(temp);
                    flag = true;
                    break;
                }
                flag = false;
            }
            if(flag == false){
                result[temp.idx] = order;
                order++;
            }

        }
        answer = result[location];

        return answer;
    }
}