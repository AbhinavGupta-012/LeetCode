class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int sum = 0;
        int i = 0;
        for (; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1] - 1){
                sum += nums[i];
            }
            else{
                break;
            }
        }
        sum += nums[i];
        while (set.contains(sum)){
            sum++;
        }
        return sum;
    }
}