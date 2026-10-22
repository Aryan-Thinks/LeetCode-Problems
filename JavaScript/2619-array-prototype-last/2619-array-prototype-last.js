// https://leetcode.com/problems/array-prototype-last

/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    
    // I was thinking of this approach
    // If (arr.length == 0) return -1
    // If arr got some length then (arr[arr.length-1])

    // Here we can use this keyword
    // this to refer to the current array instance

    // Checks for array length if empty return -1
    if (this.length === 0) return -1;
    
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */