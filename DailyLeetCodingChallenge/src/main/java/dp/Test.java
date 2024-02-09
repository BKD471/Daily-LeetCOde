package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<List<Integer>>> res=new ArrayList<>();
        List<Integer> it= Arrays.asList(1,2,3,4,5);

        for(int i=0;i<5;i++) res.add(new ArrayList<>());
        for(int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                res.get(i).set(j,it);
            }
        }

        System.out.println(res);
    }
}
