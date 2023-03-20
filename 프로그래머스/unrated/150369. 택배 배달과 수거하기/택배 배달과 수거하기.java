class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int totalDeliver = 0;
        int totalPickup = 0;
        for(int i = 0 ; i < n ; i++){
            totalDeliver += deliveries[i];
            totalPickup += pickups[i];
        }
        
        int deliverIdx = n-1;
        int pickUpIdx = n-1;
        while(true){
            //배달,수거 다하면 끝
            if(totalDeliver == 0 && totalPickup == 0)
                break;
            
            //현재 배달 할 택배 개수
            int curDeliver = 0;
            if(totalDeliver >= cap)
                curDeliver = cap;
            else
                curDeliver = totalDeliver;
            
            answer += Math.max(deliverIdx+1 , pickUpIdx+1)*2;

            //배송
            while(curDeliver > 0){
                if(deliveries[deliverIdx] >= curDeliver){
                    deliveries[deliverIdx] -= curDeliver;
                    totalDeliver -= curDeliver;
                    curDeliver = 0;
                    
                }else{
                    totalDeliver -= deliveries[deliverIdx];
                    curDeliver -= deliveries[deliverIdx];
                    deliveries[deliverIdx] = 0;
                    deliverIdx--;
                }    
            }
            
            while(deliverIdx >= 0 && deliveries[deliverIdx] == 0 ){
                deliverIdx--;
            }
            
            int curPickUp = 0;
            if(totalPickup >= cap)
                curPickUp = cap;
            else
                curPickUp = totalPickup;

            //수거
            while(curPickUp > 0){
                
                if(pickups[pickUpIdx] >= curPickUp){
                    pickups[pickUpIdx] -= curPickUp;
                    totalPickup -= curPickUp;
                    curPickUp = 0;
                    
                }else{
                    totalPickup -= pickups[pickUpIdx];
                    curPickUp -= pickups[pickUpIdx];
                    pickups[pickUpIdx] = 0;
                    pickUpIdx--;
                }    
            }
            
            while(pickUpIdx >= 0 && pickups[pickUpIdx] == 0 ){
                pickUpIdx--;
            }
        }

        return answer;
    }
}