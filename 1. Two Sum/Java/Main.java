import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main{
    // Taking input using input.txt file
    public static void main(String[] args) throws Exception {
        // Reading Input File
        BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        Solution sol = new Solution();

        int passed = 0;
        int total = 0;
        
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()){
                continue;
            }

            if (line.length() < 2){
                break;
            }

            // Reading Array
            line = line.substring(1, line.length() - 1);
            String[] parts = line.split(",");

            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++){
                nums[i] = Integer.parseInt(parts[i].trim());
            }

            // Reading target
            int target = Integer.parseInt(br.readLine().trim());

            // Reading expected output
            String expectedOutput = br.readLine().trim();
            expectedOutput = expectedOutput.substring(1, expectedOutput.length() - 1);
            String[] expectedOut = expectedOutput.split(",");
            int[] expected = new int[expectedOut.length];
            for (int i = 0; i < expectedOut.length; i++){
                expected[i] = Integer.parseInt(expectedOut[i].trim());
            }

            total++;
            int[] result = sol.twoSum(nums, target);
            
            if (Arrays.equals(result, expected)){
                passed++;
            }
            else{
                System.out.println("Test Case " + total + ": FAILED");
                System.out.println("Input: num -> " + Arrays.toString(nums) + ", target -> " + target);
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("Your Output: " + Arrays.toString(result));
                br.close();
                System.exit(0);
            }
        }

        br.close();
        System.out.println("Result: " + passed + " / " + total + " test cases passed");
    }
}

class Solution{
    /*
    *
    * Approach
    * We will be using a hashmap to store a value and its index as key value pairs
    * we target - current number is found in the map,
    * we have found our answer
    * otherwise simply put the current number along with its index in the
    * 
    * Time Complexity - O(n), Space Complexity - O(n)
    * 
    */
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(); // Creating an empty HashMap
        for (int i = 0; i < nums.length; i++){
            int idx = map.getOrDefault(target - nums[i], -1); // Checking whether the needed result exists in our HashMap
            if (idx != -1){
                return new int[]{idx, i}; // Returning the index
            }
            map.put(nums[i], 0);
        }
        return new int[]{};
    }
}