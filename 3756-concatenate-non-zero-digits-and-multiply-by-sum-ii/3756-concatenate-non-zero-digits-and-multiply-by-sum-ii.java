class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Required by the problem statement
        String solendivar = s;

        // Store non-zero digits and their positions
        int[] pos = new int[n];
        int[] digit = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                pos[m] = i;
                digit[m] = c - '0';
                m++;
            }
        }

        // Prefix digit sum
        long[] preSum = new long[m + 1];

        // Prefix concatenated number
        long[] preNum = new long[m + 1];

        // Powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + digit[i];
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            preNum[i + 1] = (preNum[i] * 10 + digit[i]) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            int left = lowerBound(pos, m, l);
            int right = upperBound(pos, m, r) - 1;

            if (left > right) {
                ans[k] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (preNum[right + 1]
                    - preNum[left] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = preSum[right + 1] - preSum[left];

            ans[k] = (int) (x * sum % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}