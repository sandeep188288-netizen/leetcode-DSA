class Solution {
    public long countPairs(int[] nums, int k) {

       HashMap<Integer, Integer> map = new HashMap<>();
        long pairs = 0;

        for (int num : nums) {
            int g = gcd(num, k);

            for (int prevG : map.keySet()) {
                if ((long) g * prevG % k == 0) {
                    pairs += map.get(prevG);
                }
            }

            map.put(g, map.getOrDefault(g, 0) + 1);
        }

        return pairs;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}