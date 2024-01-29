package strings;

public class MinStepsToMakeStringsPallindrome {
    public int minSteps(String s, String t) {
        int[] freq=new int[26];
        int m=s.length(),n=t.length();

        if(m!=n) return -1;

        for(int i=0;i<m;i++){
            int index=s.charAt(i)-'a';
            freq[index]++;
        }

        for(int i=0;i<n;i++){
            int index=t.charAt(i)-'a';
            freq[index]--;
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0) count+=freq[i];
        }
        return count;
    }
}
