package arrays;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigitsLC1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        if(low>high) return res;

        int l=Integer.toString(low).length();
        int h=Integer.toString(high).length();

        String digits="123456789";
        for(int i=l;i<=h;i++){
            for(int j=0;j<10-i;j++){
                String str=digits.substring(j,j+i);
                int v=Integer.parseInt(str);
                if(v>=low && v<=high) res.add(v);
            }
        }
        return res;
    }
}
