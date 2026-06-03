class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            solve(landStartTime, landDuration,
                  waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration,
                  landStartTime, landDuration)
        );
    }

    private int solve(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int minFinish = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            minFinish = Math.min(minFinish, start1[i] + dur1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {
            int finishTime = Math.max(minFinish, start2[i]) + dur2[i];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}