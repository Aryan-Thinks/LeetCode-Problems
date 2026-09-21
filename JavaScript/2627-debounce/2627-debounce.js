/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let timerId = null;

    return function(...args) {
        // Clear the existing timer if the function is called again within time `t`
        clearTimeout(timerId);

        // Set a new timer to execute `fn` after `t` milliseconds
        timerId = setTimeout(() => {
            fn.apply(this, args);
        }, t);
    };
};
/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */