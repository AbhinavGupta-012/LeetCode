class Encrypter {
    Map<Character, Integer> keyMap;
    Map<String, List<Integer>> valueMap;
    char[] keys;
    String[] values;
    Map<String, Integer> freq;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = keys;
        this.values = values;
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++){
            keyMap.put(keys[i], i);
            valueMap.putIfAbsent(values[i], new ArrayList<>());
            valueMap.get(values[i]).add(i);
        }
        freq = new HashMap<>();
        for (String s : dictionary){
            String word = encrypt(s);
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++){
            if (!keyMap.containsKey(word1.charAt(i))){
                return "";
            }
            sb.append(values[keyMap.get(word1.charAt(i))]);
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return freq.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */