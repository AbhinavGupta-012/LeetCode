class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] dp = new Integer[stoneValue.length];
        int ans = solve(stoneValue, 0, dp);
        return ans == 0 ? "Tie" : ans > 0 ? "Alice" : "Bob";
    }
    public int solve(int[] stones, int idx, Integer[] dp){
        if (idx == stones.length){
            return 0;
        }
        if (dp[idx] != null){
            return dp[idx];
        }
        int val1 = stones[idx] - solve(stones, idx + 1, dp);
        int val2 = idx + 1 < stones.length ? stones[idx] + stones[idx + 1] - solve(stones, idx + 2, dp) : val1;
        int val3 = idx + 2 < stones.length ? stones[idx] + stones[idx + 1] + stones[idx + 2] - solve(stones, idx + 3, dp) : val2;
        dp[idx] = Math.max(val1, Math.max(val2, val3));
        return dp[idx];
    }
}