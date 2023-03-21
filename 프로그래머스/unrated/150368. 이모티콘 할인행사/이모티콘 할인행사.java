class Solution {
    static int n,emoNum;
    static int[] output,max;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer;
        n = users.length;
        emoNum = emoticons.length;
        output = new int[emoNum];
        max = new int[]{0,0};
        
        subset(0,users,emoticons);
        answer = new int[]{max[0],max[1]};
        return answer;
    }
    
    static void subset(int cnt , int[][] users , int[] emoticons ){
        if(cnt == emoNum){
            int totalBuyPrice = 0;
            int serviceNum = 0;
            //사용자가 할인율에 따른 이모티콘 구매
            for(int i = 0 ; i < n ; i++){
                int totalUserPrice = 0;
                
                for(int j = 0 ; j < emoNum ; j++){
                    //할인율이 낮으면 구매 안함
                    if(users[i][0] > output[j]) continue;
                    
                    totalUserPrice += (emoticons[j] * (100-output[j]) )/100;
                    //이모티콘 구매후 내가 가진 가격이상 이면 서비스 가입
                    if(users[i][1] <= totalUserPrice){
                        serviceNum++;
                        totalUserPrice = 0;
                        break;
                    }
                    
                }
                totalBuyPrice += totalUserPrice;
            }

            //구매비용 및 서비스 가입여부 확인
            //max값 갱신
            if(max[0] < serviceNum){
                max[0] = serviceNum;
                max[1] = totalBuyPrice;
            }else if(max[0] == serviceNum){
                if(max[1] < totalBuyPrice)
                    max[1] = totalBuyPrice;
            }
            
            return;
        }
        
        //10퍼 할인
        output[cnt] = 10;
        subset(cnt + 1,  users , emoticons);
        
        //20퍼 할인
        output[cnt] = 20;
        subset(cnt + 1,  users , emoticons);
        //30퍼 할인
        output[cnt] = 30;
        subset(cnt + 1,users , emoticons);
        //40퍼 할인
        output[cnt] = 40;
        subset(cnt + 1, users , emoticons);
    }
}