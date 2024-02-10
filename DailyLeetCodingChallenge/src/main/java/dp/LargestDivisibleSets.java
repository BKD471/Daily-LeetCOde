package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivisibleSets {
    static Map<String, List<Integer>> memo = new HashMap<>();

    private static List<Integer> solve(int[] nums, int index, int prev_index, List<Integer> temp) {
        int t=prev_index+1;
        final String key=index+":"+t;
        System.out.println(key);
        if (index >= nums.length) {
            memo.put(key, new ArrayList<>(temp));
            //System.out.println(temp);
            return new ArrayList<>(temp);
        }

        if (memo.containsKey(key)) return new ArrayList<>(memo.get(key));
        List<Integer> take = new ArrayList<>();
        if (prev_index == -1 || nums[index] % nums[prev_index] == 0) {
            temp.add(nums[index]);
            System.out.println(temp);
            take = solve(nums, index + 1, index, temp);
            temp.remove(temp.size() - 1);
        }
        List<Integer> not_take = solve(nums, index + 1, prev_index, temp);


        List<Integer> best = (take.size() > not_take.size()) ? take : not_take;
        //System.out.println(best);
        memo.put(key, new ArrayList<>(best));
        return best;
    }


    public static void main(String[] args) {
        int[] nums={5,9,18,54,108,540,90,180,360,720};
        Arrays.sort(nums);
        memo.clear();
        List<Integer> res=solve(nums, 0, -1, new ArrayList<>());
        System.out.println(res);
        //System.out.println(memo);
    }
}
