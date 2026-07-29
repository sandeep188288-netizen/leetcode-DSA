class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        max *= 2;

        boolean[] pairXor = new boolean[max];
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }

        boolean[] tripletXor = new boolean[max];
        for (int xor = 0; xor < max; xor++) {
            if (pairXor[xor]) {
                for (int num : nums) {
                    tripletXor[xor ^ num] = true;
                }
            }
        }
        int ans = 0;
        for (boolean found : tripletXor) {
            if (found) {
                ans++;
            }
        }
        return ans;
    }
}