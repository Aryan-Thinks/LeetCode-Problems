// https://leetcode.com/problems/to-be-or-not-to-be

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {

    // Return object
    return {
        toBe : function (val2) {
            // code 
            if (val === val2) {
                return true;
            } 
            throw new Error("Not Equal");
        },

        notToBe : function (val2) {
            if (val !== val2) {
                return true;
            }
            throw new Error("Equal");
        }   
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */