// https://leetcode.com/problems/array-wrapper

/**
 * @param {number[]} nums
 */
class ArrayWrapper {
    constructor(nums) {
        this.nums = nums;
    }

    valueOf() {
        return this.nums.reduce((acc, num) => acc + num, 0);
    }

    toString() {
        return `[${this.nums.join(',')}]`;
    }
}