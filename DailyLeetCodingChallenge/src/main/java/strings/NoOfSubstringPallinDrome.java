package strings;

public class NoOfSubstringPallinDrome {
    private boolean pallindrome(String str){
        int l=0,h=str.length()-1;
        while(l<=h){
            if(str.charAt(l)!=str.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n=s.length();

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String str=s.substring(i,j+1);
                if(pallindrome(str)) count++;
            }
        }
        return count;
    }
}
