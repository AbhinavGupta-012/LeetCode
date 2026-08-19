class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> counter = new HashMap<>();
        int start = 0;
        int length = 0;
        for (int num : nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            length++;
            if (length == k){
                for (int key : counter.keySet()){
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                counter.put(nums[start], counter.get(nums[start]) - 1);
                if (counter.get(nums[start]) == 0){
                    counter.remove(nums[start]);
                }
                start++;
                length--;
            }
        }
        int res = -1;
        for (int key : map.keySet()){
            if (map.get(key) == 1 && res < key){
                res = key;
            }
        }
        return res;
    }
}