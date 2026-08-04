class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int[] freq = new int[101];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums){
            freq[num]++;
            if (num < min){
                min = num;
            }
            if (num > max){
                max = num;
            }
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = min; i <= max; i++){
            if (freq[i] == 0){
                arr.add(i);
            }
        }
        return arr;
    }
}