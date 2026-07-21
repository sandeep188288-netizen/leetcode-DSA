class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        int maxZero = 0;
        int prevZero = 0;

        int i = 0;
        while (i < s.length()) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;

            if (s.charAt(i) == '1') {
                // Count all existing 1s
                ones += len;
            } else {
                if (prevZero > 0) {
                    maxZero = Math.max(maxZero, prevZero + len);
                }

                prevZero = len;
            }

            i = j;
        }

        return ones + maxZero;
    }
}