class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] seats : reservedSeats){
            map.putIfAbsent(seats[0], new HashSet<>());
            map.get(seats[0]).add(seats[1]);
            set.add(seats[0]);
        }
        int count = 0;
        int num = n - set.size();
        count += (num * 2);
        for (int i : set){
            int length = 0;
            if (!map.containsKey(i)){
                continue;
            }
            for (int j = 1; j <= 10; j++){
                if (map.get(i).contains(j)){
                    length = 0;
                }
                else{
                    length++;
                    if (length >= 4 && (j == 4 || j == 8 || j == 10 || j == 6)){
                        continue;
                    }
                    if (length >= 4){
                        count++;
                        length = 0;
                    }
                }
            }
        }
        return count;
    }
}