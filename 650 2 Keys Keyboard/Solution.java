class Solution {
    int INF = 1000000;
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], INF);
        }
        return solve(1, 0, n, dp);
    }
    public int solve(int orig, int copy, int n, int[][] dp){
        if (orig > n){
            return INF;
        }
        if (orig == n){
            return 0;
        }
        if (dp[orig][copy] != INF){
            return dp[orig][copy];
        }
        int val1 = orig == copy ? INF : solve(orig, orig, n, dp);
        int val2 = copy > 0 ? solve(orig + copy, copy, n, dp) : INF;
        dp[orig][copy] = 1 + Math.min(val1, val2);
        return dp[orig][copy];
    }
}