class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < word1.length() && idx2 < word2.length()){
            if (word1.charAt(idx1) > word2.charAt(idx2)){
                sb.append(word1.charAt(idx1));
                idx1++;
            }
            else if (word1.charAt(idx1) < word2.charAt(idx2)){
                sb.append(word2.charAt(idx2));
                idx2++;
            }
            else{
                Boolean firstWord = null;
                int idx3 = idx1 + 1;
                int idx4 = idx2 + 1;
                while (idx3 < word1.length() && idx4 < word2.length()){
                    if (word1.charAt(idx3) > word2.charAt(idx4)){
                        firstWord = true;
                        break;
                    }
                    else if (word1.charAt(idx3) < word2.charAt(idx4)){
                        firstWord = false;
                        break;
                    }
                    else{
                        idx3++;
                        idx4++;
                    }
                }
                if (firstWord == null){
                    if (idx3 < word1.length()){
                        firstWord = true;
                    }
                    else{
                        firstWord = false;
                    }
                }
                if (firstWord){
                    sb.append(word1.charAt(idx1));
                    idx1++;
                }
                else{
                    sb.append(word2.charAt(idx2));
                    idx2++;
                }
            }
        }
        if (idx1 < word1.length()){
            sb.append(word1.substring(idx1));
        }
        if (idx2 < word2.length()){
            sb.append(word2.substring(idx2));
        }
        return sb.toString();
    }
}