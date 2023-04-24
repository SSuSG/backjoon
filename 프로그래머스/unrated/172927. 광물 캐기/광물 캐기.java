import java.util.*;
class Solution {
    static int[] output;
    static int[] Picks;
    static String[] Minerals;
    static boolean[] isVisit;
    static int n = 0,min=Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        for(int i = 0 ; i < picks.length ; i++) n += picks[i];
        Picks=picks;
        Minerals = minerals;
        output = new int[n];
        isVisit = new boolean[n];
        perm(0,0,0);
        
        return min;
    }
    
    public void perm(int cnt , int Sum, int Idx){
        if(min < Sum) return;
        if(cnt == n){
            min = Math.min(min , Sum);
            return;
        }
        
        for(int i = 0 ; i < n ; i++){
            if(isVisit[i]) continue;
            isVisit[i] = true;
            output[cnt] = i;
            //계산
            int now = i;
            int idx = Idx;
            int sum =0;
            //다이아
            if(now < Picks[0]){
                int c = 5;
                while(c-- > 0){
                    sum+=1;
                    idx++;
                    if(idx >= Minerals.length) break;           
                }
            }else if(Picks[0] <= now && now < Picks[0]+Picks[1]){
                //철
                int c = 5;
                while(c-- > 0){
                    String temp = Minerals[idx++];
                    if(temp.equals("diamond")) sum += 5;
                    else sum += 1;

                    if(idx >= Minerals.length) break;           
                }
            }else{
                //돌
                int c = 5;
                while(c-- > 0){
                    String temp = Minerals[idx++];
                    if(temp.equals("diamond")) sum += 25;
                    else if(temp.equals("iron")) sum += 5;
                    else sum += 1;

                    if(idx >= Minerals.length) break;           
                }
            }
            if(idx >= Minerals.length) perm(n,Sum+sum , idx);
            else perm(cnt+1,Sum + sum , idx);
            isVisit[i] = false;
        }
        
    }
}