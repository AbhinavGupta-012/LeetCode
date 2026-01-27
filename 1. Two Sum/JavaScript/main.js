const fs = require("fs");

/** 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
*/

var twoSum = function(nums, target){
    let map = new Map();
    for (let i = 0; i < nums.length; i++){
        let val = target - nums[i];
        if (map.has(val)){
            return [map.get(val), i];
        }
        map.set(nums[i], i);
    }
    return [];
}

let lines;

try{
    lines = fs.readFileSync("../input.txt", "utf-8").split(/\r?\n/);
}
catch (e){
    console.log("Failed to open input.txt");
    process.exit(1);
}

let passed = 0;
let total = 0;
let i = 0;

while (i < lines.length){
    let line = lines[i].trim();
    i++;

    if (!line){
        continue;
    }

    if (line.length < 2){
        break;
    }

    let arrStr = line.slice(1, -1);
    let nums = [];
    if (arrStr.length > 0){
        nums = arrStr.split(",").map(x => parseInt(x.trim()));
    }

    if (i >= lines.length){
        break;
    }
    
    let target = parseInt(lines[i].trim());
    i++;

    if (i >= lines.length){
        break;
    }

    let expectedLine = lines[i].trim();
    i++;

    let expectedStr = expectedLine.slice(1, -1);
    let expected = [];
    if (expectedStr.length > 0){
        expected = expectedStr.split(",").map(x => parseInt(x.trim()));
    }

    total++;
    let result = twoSum(nums, target);

    if (JSON.stringify(result) === JSON.stringify(expected)){
        passed++;
    }
    else{
        console.log(`Test Case ${total}: FAILED`);
        console.log(`Input: nums = [${nums}], target = ${target}`);
        console.log(`Expected: [${expected}]`);
        console.log(`Your Output: [${result}]`);
        process.exit(0);
    }
}

console.log(`Result: ${passed} / ${total} test cases passed`);