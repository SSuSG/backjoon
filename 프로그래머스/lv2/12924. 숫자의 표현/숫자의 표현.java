class Solution {
    static int result = 0;
    static boolean[] isSelect;
    
    public int solution(int n) {
        int answer = 0;
        isSelect = new boolean[n+1];
        
        recur(n);
        return result;
    }
    
    public void recur(int n){
        for(int i = 1 ; i <= n ; i++){
            int sum = 0;
            for(int j = i; j <= n ; j++){
                sum += j;
                if(sum > n)
                    break;
                if(sum == n){
                    result++;
                    break;   
                }
            }           
        }
    }
}