/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = {};

    // Store all items from arr1 in the map using their id as the key
    for (const item of arr1) {
        map[item.id] = { ...item };
    }

    // Process arr2 items
    for (const item of arr2) {
        if (!map[item.id]) {
            map[item.id] = { ...item };
        } else {
            // Merge properties, with arr2 overriding arr1
            for (const key of Object.keys(item)) {
                map[item.id][key] = item[key];
            }
        }
    }

    // Extract values and sort by id in ascending order
    return Object.values(map).sort((a, b) => a.id - b.id);
};