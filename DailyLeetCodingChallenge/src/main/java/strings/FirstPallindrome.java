package strings;

public class FirstPallindrome {
    private boolean isPallindrome(String str){
        int l=0,h=str.length()-1;
        while(l<=h){
            if(str.charAt(l)!=str.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        int n=words.length;
        for(int i=0;i<n;i++){
            if(isPallindrome(words[i])) return words[i];
        }
        return "";
    }
}
