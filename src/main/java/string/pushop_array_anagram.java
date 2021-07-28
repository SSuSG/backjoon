package string;

import java.util.*;

public class pushop_array_anagram {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = solve(strs);
        System.out.println("output = " + output);
    }

    public static List<List<String>> solve(String[] strs){

        List<List<String>> result = new ArrayList<>();
        Map<String , List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr=str.toCharArray();
            Arrays.sort(arr);

            String key=String.valueOf(arr);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        result.addAll(map.values());
        return result;
    }


}
