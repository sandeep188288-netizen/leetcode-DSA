class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;

        for(int i = 0; i < nums.size(); i++) {
            HashSet<Integer> s = new HashSet<>();

            for(int j = i; j < nums.size(); j++) {
                s.add(nums.get(j));
                ans += s.size() * s.size();
            }
        }

        return ans;
    }
}