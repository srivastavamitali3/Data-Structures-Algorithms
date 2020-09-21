package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            Integer value = map.get(target - nums[i]);
            if(value == null)
                map.put(nums[i],i);
            else{
                result[0]= value;
                result[1]=i;
                break;
            }
        }
        return result;


    }
}
