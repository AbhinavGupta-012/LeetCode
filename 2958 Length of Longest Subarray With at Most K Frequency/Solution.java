    class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int length = 0;
        int start = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            length++;
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            while (counter.get(nums[i]) > k){
                counter.put(nums[start], counter.get(nums[start]) - 1);
                if (counter.get(nums[start]) == 0){
                    counter.remove(nums[start]);
                }
                length--;
                start++;
            }
            if (length > max){
                max = length;
            }
        }
        return max;
    }
}