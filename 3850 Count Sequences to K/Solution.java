class Solution {
    public int countSequences(int[] nums, long k) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(nums, 0, 1, 1, k, dp);
    }
    public int solve(int[] nums, int idx, long num, long deno, long k, Map<String, Integer> dp){
        if (idx == nums.length){
            if (num == k && deno == 1){
                return 1;
            }
            return 0;
        }
        String s = idx + " " + num + " " + deno;
        if (dp.containsKey(s)){
            return dp.get(s);
        }
        int val1 = solve(nums, idx + 1, num, deno, k, dp);
        num *= nums[idx];
        long gcd = gcd(num, deno);
        int val2 = solve(nums, idx + 1, num / gcd, deno / gcd, k, dp);
        num /= nums[idx];
        deno *= nums[idx];
        gcd = gcd(num, deno);
        int val3 = solve(nums, idx + 1, num / gcd, deno / gcd, k, dp);
        deno /= nums[idx];
        String str = idx + " " + num + " " + deno;
        dp.put(str, val1 + val2 + val3);
        return dp.get(str);
    }
    public long gcd(long a, long b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}