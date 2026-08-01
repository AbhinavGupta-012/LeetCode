class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }
    public boolean solve(int[] nums, int left, int right, int p1, int p2, boolean turn){
        if (left > right){
            if (p1 >= p2){
                return true;
            }
            return false;
        }
        if (turn){
            p1 += nums[left];
        }
        else{
            p2 += nums[left];
        }
        boolean val1 = solve(nums, left + 1, right, p1, p2, !turn);
        if (turn){
            p1 -= nums[left];
            p1 += nums[right];
        }
        else{
            p2 -= nums[left];
            p2 += nums[right];
        }
        boolean val2 = solve(nums, left, right - 1, p1, p2, !turn);
        if (turn){
            return val1 || val2;
        }
        return val1 && val2;
    }
}