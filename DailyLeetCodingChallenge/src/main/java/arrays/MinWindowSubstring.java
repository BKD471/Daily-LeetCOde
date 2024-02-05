package arrays;

public class MinWindowSubstring {
    private boolean check(int[] freq1,int[] freq2){
        for(int i=0;i<127;i++){
            if(freq1[i]<freq2[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(n>m) return "";

        int[] freq1=new int[127];
        int[] freq2=new int[127];
        for(int i=0;i<n;i++){
            int index1=s.charAt(i);
            int index2=t.charAt(i);
            freq1[index1]++;
            freq2[index2]++;
        }
        if(check(freq1,freq2)) return s.substring(0,n);

        int l=0,r=n,minSize=Integer.MAX_VALUE;
        int start=-1,end=-1;

        int[] countFreq=new int[127];
        while(r<m){
            freq1[s.charAt(r)]++;
            while(check(freq1,freq2)){
                int size=r-l+1;
                if(size<minSize){
                    minSize=size;
                    start=l;
                    end=r;
                }
                freq1[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        return minSize==Integer.MAX_VALUE?"":s.substring(start,end+1);
    }
}
