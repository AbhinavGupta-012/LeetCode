class Solution {
    public boolean stoneGame(int[] piles) {
        Integer[][] dp = new Integer[piles.length][piles.length];
        int ans = solve(piles, 0, piles.length - 1, dp);
        return ans < 0 ? false : true;
    }
    public int solve(int[] piles, int left, int right, Integer[][] dp){
        if (left == right){
            return piles[left];
        }
        if (dp[left][right] != null){
            return dp[left][right];
        }
        int val1 = piles[left] - solve(piles, left + 1, right, dp);
        int val2 = piles[right] - solve(piles, left, right - 1, dp);
        dp[left][right] = Math.max(val1, val2);
        return dp[left][right];
    }
}