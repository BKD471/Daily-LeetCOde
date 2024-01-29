package strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
        private boolean validateIsAnagram(int[] freq1, int[] freq2) {
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) return false;
            }
            return true;
        }

        public List<Integer> findAnagrams(String s, String p) {
            int m = s.length(), n = p.length();
            List<Integer> res = new ArrayList<>();
            if (m == 0 || n == 0 || n > m) return res;

            int[] freq1 = new int[26];
            for (int i = 0; i < n; i++) {
                int index = p.charAt(i) - 'a';
                freq1[index]++;
            }

            int[] freq2 = new int[26];
            for (int i = 0; i < n; i++) {
                int index = s.charAt(i) - 'a';
                freq2[index]++;
            }
            if (validateIsAnagram(freq1, freq2)) res.add(0);

            int l = 0, k = n;
            while (k < m) {
                int index = s.charAt(l) - 'a';
                freq2[index]--;

                index = s.charAt(k) - 'a';
                freq2[index]++;

                if (validateIsAnagram(freq1, freq2)) res.add(l + 1);
                l++;
                k++;
            }
            return res;
        }
}
