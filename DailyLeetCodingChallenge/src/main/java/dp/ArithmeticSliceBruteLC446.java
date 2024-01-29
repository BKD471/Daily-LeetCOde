package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSliceBruteLC446 {
    static List<List<Integer>> resultantList=new ArrayList<>();
    private static void generateSubSeq(int[] res,List<Integer> temp,int index){
        if(index>=res.length){
            resultantList.add(new ArrayList<>(temp));
            return;
        }

        temp.add(res[index]);
        generateSubSeq(res,temp,index+1);
        temp.remove(temp.size()-1);
        generateSubSeq(res,temp,index+1);
    }

    private static boolean checkArithmeticSlice(List<Integer> temp){
        int n=temp.size();
        if(n<3) return false;
        for(int i=2;i<n;i++){
            if(temp.get(i)-temp.get(i-1)!=temp.get(i-1)-temp.get(i-2)) return false;
        }
        return true;
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        generateSubSeq(nums,new ArrayList<>(),0);

        int cnt=0;
        for(List<Integer> t:resultantList){
            if(checkArithmeticSlice(t)){
                System.out.println(t);
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums= {2,4,6,8,10};
        System.out.println(nums.length);
        int res=numberOfArithmeticSlices(nums);
        System.out.println(res);
    }
}
