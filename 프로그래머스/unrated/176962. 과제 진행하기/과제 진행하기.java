import java.util.*;
class Solution {
    static plan[] planArr;
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        planArr = new plan[plans.length];
        for(int i = 0 ; i < plans.length ; i++){
            String[] split = plans[i][1].split(":");
            int start = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
            planArr[i] = new plan(plans[i][0],start,Integer.parseInt(plans[i][2]));
        }
        
        Stack<plan> remain = new Stack<>();
        Arrays.sort(planArr , (o1,o2) -> o1.start-o2.start);
        
        for(int i = 0 ; i < planArr.length-1 ; i++){
            if(planArr[i].start + planArr[i].playTime <= planArr[i+1].start){
                answer.add(planArr[i].name);
                /*
                int rem = planArr[i+1].start - (planArr[i].start + planArr[i].playTime);
                
                while(rem > 0 && !remain.isEmpty()){
                    if(remain.peek().playTime <= rem){
                        answer.add(remain.pop().name);
                        rem -= remain.peek().playTime;
                    }else{
                        remain.peek().playTime -= rem;
                        rem = 0;
                    }
                }
                */
                int jjaturi = planArr[i+1].start - (planArr[i].start + planArr[i].playTime);
                while(jjaturi > 0 && !remain.isEmpty()){
                    int del = remain.peek().playTime - jjaturi;
                    remain.peek().playTime = Math.max(0, del);
                    if(del <= 0) {
                        jjaturi = -1 * del;
                        answer.add(remain.pop().name);
                    }else{
                        jjaturi = 0;
                    }
                }
                
            }else{
                planArr[i].playTime -= (planArr[i+1].start - planArr[i].start);
                remain.push(planArr[i]);
            }
        }
        answer.add(planArr[planArr.length-1].name);
        while(!remain.isEmpty()) 
            answer.add(remain.pop().name);
        
        return answer.toArray(String[]::new);
    }
    static class plan{
        String name;
        int start;
        int playTime;
        public plan(String name , int start , int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}