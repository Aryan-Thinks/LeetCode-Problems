// https://leetcode.com/problems/apply-transform-over-each-element-in-array

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {

    let returnedArr = [];
    
    // Loop
    for (let i=0 ; i<arr.length ; i++){
        let val = fn(arr[i] , i);
        returnedArr.push(val);
    }

    return returnedArr;

    // Using .map
    // return arr.map((value, index) => fn(value, index));
};