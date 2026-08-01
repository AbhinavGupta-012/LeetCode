class Solution {
    public int countValidPrefixes(String s) {
        int zeroes = 0;
        int ones = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                zeroes++;
            }
            else{
                ones++;
            }
            if (Math.abs(zeroes - ones) <= 1){
                total++;
            }
        }
        return total;
    }
}