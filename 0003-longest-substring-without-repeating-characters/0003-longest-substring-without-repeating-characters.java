class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
                j++;

            } else {
                int len = j - i;
                maxLen = Math.max(maxLen, len);
                while(s.charAt(i) != s.charAt(j)) {

                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        int len = j - i;
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
}