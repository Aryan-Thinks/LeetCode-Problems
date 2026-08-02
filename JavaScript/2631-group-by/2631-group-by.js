/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
    // Object to store grouped elements
    const grouped = {};

    // Iterate through each element in the array
    for (const item of this) {
        // Compute the key using the callback function
        const key = fn(item);

        // If the key doesn't exist, initialize it with an empty array
        if (!grouped[key]) {
            grouped[key] = [];
        }

        // Add the current item to its corresponding group
        grouped[key].push(item);
    }

    // Return the grouped object
    return grouped;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */