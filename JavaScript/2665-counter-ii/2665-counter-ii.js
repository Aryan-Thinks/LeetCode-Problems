// https://leetcode.com/problems/counter-ii

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */

// Optimized
var createCounter = function(init) {
    let current = init;

    return {
        increment: () => ++current,
        decrement: () => --current,
        reset: () => (current = init)  // Direct assignment
    };
};


// var createCounter = function (init) {
//     let currentCount = init;

//     return {
//         increment: function () {
//             currentCount++;
//             return currentCount;
//         },
//         decrement: function () {
//             currentCount--;
//             return currentCount;
//         },
//         reset: function () {
//             currentCount = init;
//             return currentCount;
//         },
//     };
// };

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */