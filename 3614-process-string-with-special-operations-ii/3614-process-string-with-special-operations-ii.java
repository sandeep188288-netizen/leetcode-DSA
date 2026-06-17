class Solution {
    public char processStr(String s, long k) {
        long m = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                m = Math.max(0, m - 1);
            } 
            else if (c == '#') {
                m *= 2;
            } 
            else if (c == '%') {
                // length unchanged
            } 
            else {
                m++;
            }
        }

        if (k >= m) return '.';

        // Reverse process
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                m++;
            }
            else if (c == '#') {
                m /= 2;
                if (k >= m) {
                    k -= m;
                }
            }
            else if (c == '%') {
                k = m - 1 - k;
            }
            else {
                m--;
                if (k == m) {
                    return c;
                }
            }
        }

        return '.';
    }
}