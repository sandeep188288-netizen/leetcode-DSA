class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        int end = -1;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (i != first[c]) continue;

            int r = last[c];
            boolean ok = true;

            for (int j = i; j <= r; j++) {
                int x = s.charAt(j) - 'a';

                if (first[x] < i) {
                    ok = false;
                    break;
                }

                r = Math.max(r, last[x]);
            }

            if (ok) {
                if (i > end) {
                    ans.add(s.substring(i, r + 1));
                    end = r;
                } else {
                    ans.set(ans.size() - 1, s.substring(i, r + 1));
                    end = r;
                }
            }
        }

        return ans;
    }
}