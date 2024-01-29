package arrays;

public class NumberOfLaserBeamsLC2125 {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int currCnt=0,prevCnt=0,res=0;
        for(int i=0;i<n;i++){
            String str=bank[i];
            currCnt=0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='1') currCnt++;
            }

            res+=(prevCnt*currCnt);
            if(currCnt!=0) prevCnt=currCnt;
        }
        return res;
    }
}
