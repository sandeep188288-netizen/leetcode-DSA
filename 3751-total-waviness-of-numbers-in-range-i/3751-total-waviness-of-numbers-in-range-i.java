class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            ans += getWaviness(x);
        }

        return ans;
    }

    private int getWaviness(int x) {
        int prev = x % 10;
        x /= 10;

        int cur = x % 10;
        x /= 10;

        int count = 0;

        while (x > 0) {
            int next = x % 10;
            if ((cur > prev && cur > next) ||
                (cur < prev && cur < next)) {
                count++;
            }

            prev = cur;
            cur = next;
            x /= 10;
        }

        return count;
    }
}