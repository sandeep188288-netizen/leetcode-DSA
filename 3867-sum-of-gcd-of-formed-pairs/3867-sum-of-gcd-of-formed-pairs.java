class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            a[i] = gcd(nums[i], mx);
        }

        Arrays.sort(a);

        long sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += gcd(a[i], a[n - 1 - i]);
        }

        return sum;
    }

    int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}