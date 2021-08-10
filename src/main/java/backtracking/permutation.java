package backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    static int count = 1;
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<Integer> tempList = new ArrayList<>();
        backtrack(tempList , nums);
        System.out.println("result = " + result);
    }

    private static void backtrack(List<Integer> tempList, int[] nums) {

        if(tempList.size() == nums.length){
            System.out.println("tempList = " + tempList);
            result.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backtrack(tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
