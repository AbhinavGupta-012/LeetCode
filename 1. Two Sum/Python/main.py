from typing import List

def main():
    sol = Solution()
    passed = 0
    total = 0

    try:
        with open("../input.txt", "r") as f:
            lines = f.readlines()
    except FileNotFoundError:
        print("Failed to open input.txt")
        return
    
    i = 0
    n = len(lines)

    while i < n:
        line = lines[i].strip()
        i += 1

        if not line:
            continue

        if len(line) < 2:
            break

        # Reading Array
        arr_str = line[1: -1]
        nums = []
        if arr_str:
            nums = list(map(int, arr_str.split(",")))

        # Reading Target
        if i >= n:
            break
        target = int(lines[i].strip())
        i += 1

        # Reading expected output
        if i >= n:
            break
        expected_line = lines[i].strip()
        i += 1

        expected_str = expected_line[1:-1]
        expected = []
        if expected_str:
            expected = list(map(int, expected_str.split(",")))

        total += 1
        result = sol.twoSum(nums, target)

        if result == expected:
            passed += 1
        else:
            print(f"Test Case {total}: FAILED")
            print(f"Input: nums = {nums}, target = {target}")
            print(f"Expected: {expected}")
            print(f"Your Output: {result}")
            return
    
    print(f"Result: {passed} / {total} test cases passed")


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(0, len(nums)):
            val = target - nums[i]
            if val in map:
                return [map[val], i]
            
            map[nums[i]] = i
        
        return []
    
if __name__ == "__main__":
    main()