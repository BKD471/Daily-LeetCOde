package arrays;

import java.util.Arrays;
import java.util.List;

public class DetermineTwoStringHalvesAreAlikeLC1704 {
    private int countVowels(String tempString){
        List<Character> vowels= Arrays.asList('a','e','i','o','u',
                'A','E','I','O','U');

        int vowelCount=0;
        for(char ch:tempString.toCharArray()){
            if(vowels.contains(ch)) vowelCount++;
        }
        return vowelCount;
    }
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        if(n%2!=0) return false;

        int l=0,h=n/2-1,l1=n/2,h1=n-1;
        int cnt1=countVowels(s.substring(l,h+1));
        int cnt2=countVowels(s.substring(l1,h1+1));
        return cnt1==cnt2;
    }
}
