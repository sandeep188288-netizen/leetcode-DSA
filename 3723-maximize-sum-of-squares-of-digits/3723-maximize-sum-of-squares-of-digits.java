class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || (long) num * 9 < sum) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int d = Math.min(9, sum);
            while (sum - d > 9 * (num - 1 - i)) d--;
            sb.append(d);
            sum -= d;
        }
        if (sum == 0) return sb.toString();
        return "";
    }
}