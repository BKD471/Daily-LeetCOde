package arrays;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] freq=new int[127];
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i);
            freq[index]++;
        }

        for(int i=0;i<s.length();i++){
            int index=s.charAt(i);
            if(freq[index]==1) return i;
        }
        return -1;
    }
}
