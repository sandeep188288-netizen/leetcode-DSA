class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // ✅ Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n ; j++) {

                // ✅ Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        result.add(Arrays.asList(
                            nums[i], nums[j], nums[k], nums[l]
                        ));

                        k++;
                        l--;

                        // ✅ Skip duplicate k
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // ✅ Skip duplicate l
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
  