package arrays;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConvertArrayTo2DArray {

    /********************** First Approach  **********************/
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        if(n==0) return res;

        List<Set<Integer>> temp=new ArrayList<>();

        temp.add(0,new HashSet<>());
        temp.get(0).add(nums[0]);
        int size=0;
        for(int i=1;i<n;i++){
            int key=nums[i];
            boolean found=false;
            for(int index=0;index<=size;index++){
                if(!temp.get(index).contains(key)){
                    temp.get(index).add(key);
                    found=true;
                    break;
                }
            }
            if(!found) {
                ++size;
                temp.add(size,new HashSet<>());
                temp.get(size).add(key);
            }
        }

        for(Set<Integer> tempSet:temp) res.add(new ArrayList<>(tempSet));
        return res;
    }

    //

    /**********BEST APPROACH************/
    public List<List<Integer>> findMatrixBest(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        if(n==0) return res;

        Map<Integer,Integer> hash=new ConcurrentHashMap<>();
        for(int i=0;i<n;i++){
            hash.put(nums[i], hash.getOrDefault(nums[i],0)+1);
        }

        while(!hash.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int key:hash.keySet()){
                if(hash.get(key)>0) temp.add(key);
                hash.put(key,hash.get(key)-1);
                if(hash.get(key)==0) hash.remove(key);
            }
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums={1,3,4,1,2,3,1};
        findMatrix(nums);
    }
}
