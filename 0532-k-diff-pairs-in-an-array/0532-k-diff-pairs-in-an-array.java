class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int pairs = 0;

        for (int ele : map.keySet()) {
            if (k == 0) {
                if (map.get(ele) > 1) pairs++;
            } else {
                if (map.containsKey(ele + k)) pairs++;
            }
        }

        return pairs;
    }
}