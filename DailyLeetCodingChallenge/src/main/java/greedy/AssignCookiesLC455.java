package greedy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AssignCookiesLC455 {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length,n=s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt=0;
        int i=m-1,j=n-1;
        while(i>=0 && j>=0){
            if(g[i]<=s[j]){
                cnt++;
                i--;
                j--;
            }else i--;
        }
        return cnt;
    }
}
