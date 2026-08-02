class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                long prod = (long) nums[i] * nums[j];
                long gcd = (long) gcd(nums[i], nums[j]);
                gcd *= gcd;
                long total = (prod / gcd);
                if (total > max){
                    max = total;
                }
            }
        }
        return max;
    }
    public int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}