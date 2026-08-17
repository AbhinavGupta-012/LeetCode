class Solution {
    public long maximumTripletValue(int[] nums) {
        TreeSet<Integer> left = new TreeSet<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int num : nums){
            right.put(num, right.getOrDefault(num, 0) + 1);
        }
        long max = 0;
        left.add(nums[0]);
        right.put(nums[0], right.get(nums[0]) - 1);
        if (right.get(nums[0]) == 0){
            right.remove(nums[0]);
        }
        for (int i = 1; i < nums.length - 1; i++){
            right.put(nums[i], right.get(nums[i]) - 1);
            if (right.get(nums[i]) == 0){
                right.remove(nums[i]);
            }
            if (left.last() > nums[i]){
                long val = left.last() - nums[i];
                val *= right.lastKey();
                if (val > max){
                    max = val;
                }
            }
            left.add(nums[i]);
        }
        return max;
    }
}