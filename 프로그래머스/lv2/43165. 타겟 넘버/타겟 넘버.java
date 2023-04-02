class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,0,target);
        return answer;
    }
    
    static void dfs(int idx , int[] numbers , int sum , int target){
        if(idx == numbers.length){
            if(sum == target)
                answer++;  
            return;
        }
        
        dfs(idx+1 , numbers , sum + numbers[idx] , target);
        dfs(idx+1 , numbers , sum - numbers[idx] , target);
        
    }
}