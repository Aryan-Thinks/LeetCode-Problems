// https://leetcode.com/problems/event-emitter

class EventEmitter {
    constructor() {
        this.events = new Map();
    }
    
    subscribe(eventName, callback) {
        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }
        
        const listeners = this.events.get(eventName);
        listeners.push(callback);
        
        return {
            unsubscribe: () => {
                const index = listeners.indexOf(callback);
                if (index !== -1) {
                    listeners.splice(index, 1);
                }
            }
        };
    }
    
    emit(eventName, args = []) {
        if (!this.events.has(eventName)) {
            return [];
        }
        
        const listeners = this.events.get(eventName);
        // Create a copy of the array to safely handle mutations during emission
        return listeners.slice().map(callback => callback(...args));
    }
}