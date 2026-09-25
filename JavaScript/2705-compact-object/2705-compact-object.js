// https://leetcode.com/problems/compact-object

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */

var compactObject = function(obj) {
    // Base case: if it's null or not an object, return it as-is
    if (obj === null || typeof obj !== 'object') {
        return obj;
    }

    // Check if the current structure is an array
    const isArray = Array.isArray(obj);
    const result = isArray ? [] : {};

    for (const key in obj) {
        const value = obj[key];
        const compactedValue = compactObject(value); // Recursive call

        // If the resulting value is truthy, keep it
        if (Boolean(compactedValue)) {
            if (isArray) {
                result.push(compactedValue);
            } else {
                result[key] = compactedValue;
            }
        }
    }

    return result;
};