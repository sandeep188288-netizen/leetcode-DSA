class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;

            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || j == k || i == k) continue;
                    if (digits[k] % 2 != 0) continue;

                    set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }

        return set.size();
    }
}