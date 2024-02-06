package strings;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagram {
    private boolean checkIsAnagram(String a,String b){
        int m=a.length(),n=b.length();
        if(m!=n) return false;
        int[] freq1=new int[26];
        for(int i=0;i<m;i++){
            int index=a.charAt(i)-'a';
            freq1[index]++;
        }

        int[] freq2=new int[26];
        for(int i=0;i<n;i++){
            int index=b.charAt(i)-'a';
            freq2[index]++;
        }

        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();

        int n=strs.length;
        for(int i=0;i<n;i++){
            List<String> temp=new ArrayList<>();
            String a=strs[i];
            if(a=="-1") continue;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                String b=strs[j];
                if(b=="-1") continue;
                if(checkIsAnagram(a,b)) {
                    temp.add(b);
                    strs[j]="-1";
                }
            }
            temp.add(a);
            strs[i]="-1";
            res.add(temp);
        }
        return res;
    }
}
