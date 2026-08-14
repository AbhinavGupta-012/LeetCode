class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j <= s.length(); j++){
                String sub = s.substring(i, j);
                int[] freq = new int[26];
                boolean check = true;
                for (char ch : sub.toCharArray()){
                    freq[ch - 97]++;
                    if (freq[ch - 97] == 3){
                        check = false;
                        break;
                    }
                }
                if (check){
                    if (sub.length() > max){
                        max = sub.length();
                    }
                }
            }
        }
        return max;
    }
}