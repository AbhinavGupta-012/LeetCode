#include <bits/stdc++.h>
using namespace std;

class Solution{
    public:
        vector<int> twoSum(vector<int>& nums, int target){
            unordered_map<int, int> map;
            for (int i = 0; i < nums.size(); i++){
                int val = target - nums[i];
                if (map.find(val) != map.end()){
                    return {map[val], i};
                }
                map.insert({nums[i], i});
            }
            return {};
        }
};

int main(){
    ifstream fin("../input.txt");
    if (!fin.is_open()){
        cerr << "Failed to open input.txt" << endl;
        return 1;
    }
    
    Solution sol;

    int passed = 0;
    int total = 0;

    string line;
    while (getline(fin, line)){
        line.erase(remove_if(line.begin(), line.end(), ::isspace), line.end());

        if (line.empty()){
            continue;
        }

        if (line.size() < 2){
            break;
        }

        // Reading Array
        line = line.substr(1, line.size() - 2);
        vector<int> nums;
        if (!line.empty()){
            stringstream ss(line);
            string token;
            while (getline(ss, token, ',')){
                nums.push_back(stoi(token));
            }
        }

        // Reading target
        string targetLine;
        if (!getline(fin, targetLine)){
            break;
        }
        int target = stoi(targetLine);

        // Reading expected output
        string expectedLine;
        if (!getline(fin, expectedLine)){
            break;
        }
        expectedLine.erase(remove_if(expectedLine.begin(), expectedLine.end(), ::isspace), expectedLine.end());
        expectedLine = expectedLine.substr(1, expectedLine.size() - 2);

        vector<int> expected;
        if (!expectedLine.empty()){
            stringstream ss(expectedLine);
            string token;
            while (getline(ss, token, ',')){
                expected.push_back(stoi(token));
            }
        }

        total++;
        vector<int> result = sol.twoSum(nums, target);
        if (result == expected){
            passed++;
        }
        else{
            cout << "Test Case " << total << ": FAILED" << endl;
            cout << "Input: nums = [";
            for (int i = 0; i < nums.size(); i++){
                cout << nums[i] << (i + 1 < nums.size() ? "," : "");
            }
            cout << "], target = " << target << endl;

            cout << "Expected: [";
            for (int i = 0; i < expected.size(); i++){
                cout << expected[i] << (i + 1 < expected.size() ? "," : "");
            }
            cout << "]" << endl;

            cout << "Your Output: [";
            for (int i = 0; i < result.size(); i++){
                cout << result[i] << (i + 1 < result.size() ? "," : "");
            }
            cout << "]" << endl;
            return 1;
        }
    }

    cout << "Result: " << passed << " / " << total << " test cases passed" << endl;
    return 0;
}