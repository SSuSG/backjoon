import java.util.*;
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int sum = 0;
        //모든 트럭에 대해서
        for(int i = 0 ; i < truck_weights.length ; i++){

            while(true){
                //만약 다리에 아무 트럭도 없다면 
                if(bridge.isEmpty()){
                    bridge.add(truck_weights[i]);
                    sum += truck_weights[i];
                    time++;
                    break;
                }else if(bridge.size() == bridge_length){
                    sum -= bridge.poll();
                }else{
                    //다리가 추가될 트럭의 무게를 견딜수 있다면
                    if(sum + truck_weights[i] <= weight){
                        sum += truck_weights[i];
                        time++;
                        bridge.add(truck_weights[i]);
                        break;
                    }else{
                        //다리가 추가될 트럭의 무게를 견딜수 없다면
                        bridge.add(0);
                        time++;
                    } 
                }
            }        
        }
        time += bridge_length;
        
        return time;
    }
}