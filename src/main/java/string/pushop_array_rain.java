package string;

public class pushop_array_rain {

    public static void main(String[] args) {
        
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        int result = solve(height);
        System.out.println("result = " + result);
    }
    
    public static int solve(int[] height){
        int result = 0 ;
        int n = height.length;

        for (int i = 1 ; i < n-1 ; i++){
            int maxLeft = 0 , maxRight = 0;
            for(int j = i ; j >= 0 ; j--)
                maxLeft = Math.max(maxLeft , height[j]);
            for(int j = i ; j < n ; j++)
                maxRight = Math.max(maxRight , height[j]);

            result += Math.min(maxLeft,maxRight) - height[i];
            System.out.print(result+" ");
        }

        return result;
    }
    
}
