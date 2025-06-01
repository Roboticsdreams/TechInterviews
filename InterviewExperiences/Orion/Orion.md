# Orion

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [Orion](../Orion/Orion.md)

# Round -1
# Interview Questions

1. [What is SOLID Principles?](#what-is-solid-principles)
    SOLID Principles:
    1. Single Responsibility - a class should have only one reason to change
    2. Open Closed - a class should be open for extension but closed for modification
    3. Liskov Substitution - objects in a program should be replaceable with instances of their subtypes
    4. Interface Segregation - a class should have as few interfaces as possible
    5. Dependency Inversion - high-level modules should not depend on low-level modules, but both should depend on abstractions

2. [What is Thread safe?](#what-is-thread-safe)
    Thread safe:
    1. Atomic -  perform atomic operations, which are thread-safe, without using synchronization. executed in one single thread
    2. Volatile - volatile variables are used to ensure that a variable is accessed by multiple threads.
    3. Synchronized -  used to ensure that only one thread can access a variable at a time.

3. [How to manage Transaction Management is spring boot?](#how-to-manage-transaction-management-is-spring-boot)
    Transaction Management is spring boot:
    - @Transactional annotation is the metadata used for managing transactions in the Spring Boot application. 
    - To configure Spring Transaction, this annotation can be applied at the class level or method level. 
    -In an enterprise application, a transaction is a sequence of actions performed by the application that together pipelined to perform a single operation. 
    - For example, booking a flight ticket is also a transaction where the end user has to enter his information and then make a payment to book the ticket.

4. [What are the annotations in the springboot?](#what-are-the-annotations-in-the-springboot)
    Annotations in the springboot:
    - @Controller - used to create web controllers.
    - @Service - used to create business services.
    - @Repository - used to create repositories.
    - @Configuration - used to create configurations.
    - @Component - used to create components.
    - @Autowired - used to inject dependencies.
    - @Value - used to inject values.
    - @RestController - used to create RESTful web services.
    - @RequestMapping - used to specify the URL mapping.
    - @GetMapping - used to map HTTP GET requests.
    - @PostMapping - used to map HTTP POST requests.
    - @PutMapping - used to map HTTP PUT requests.
    - @DeleteMapping - used to map HTTP DELETE requests.
    - @PathVariable - used to map URL variables.
    - @RequestParam - used to map query parameters.
    - @RequestBody - used to map request body.
    - @ResponseBody - used to map response body.
    - @RequestHeader - used to map request headers.
    - @CookieValue - used to map cookie values.
    - @ExceptionHandler - used to handle exceptions.
    - @ResponseStatus - used to set the HTTP status code.
    - @Bean - used to create beans.
    - @Transactional - used to manage transactions.

5. [List of React hooks?](#list-of-react-hooks)

React hooks:
- useState: Manages local state in a functional component.
- useEffect: Runs side effects in response to state or prop changes (e.g., data fetching, subscriptions).
- useContext: Accesses and subscribes to context values within a component.
- useReducer: Manages complex state logic with a reducer function, often used as an alternative to `useState`.
- useCallback: Memoizes a function, returning the same instance unless dependencies change (useful for optimizing - mance).
- useMemo: Memoizes a computed value, recalculating only when dependencies change.
- useRef: Holds a mutable reference to a DOM element or value that persists across renders.
- useLayoutEffect: Similar to `useEffect`, but fires synchronously after DOM updates (useful for layout calculations).
- useImperativeHandle: Customizes a ref’s exposed instance values when used with `forwardRef`.
- useDebugValue: Provides custom labels or values to improve debugging information for custom hooks.
- useTransition: Manages transitions by allowing some state updates to be marked as non-urgent.
- useDeferredValue: Delays updates to a less urgent value, improving performance in heavy renders.
- useId: Generates a unique ID for accessibility and identification without causing re-renders. 


6. [Difference between Arraylist, LinkedList and Hashmap?](#difference-between-arraylist-linkedlist-and-hashmap)

### ArrayList
- Type: List implementation.
- Order: Ordered by index; maintains the insertion order.
- Access Speed: Fast random access with index-based retrieval (efficient for retrieving elements).
- Insertion/Deletion: Slower for adding or removing elements, especially in the middle, due to shifting of elements.
- Usage: Preferred for scenarios where frequent access of elements is required without much insertion/deletion.

### LinkedList
- Type: List implementation.
- Order: Ordered by sequence; maintains the insertion order.
- Access Speed: Slower random access as it requires traversal of nodes sequentially.
- Insertion/Deletion: Efficient for adding or removing elements, especially at the beginning or middle, since only pointers are adjusted.
- Usage: Preferred for scenarios with frequent insertions or deletions within the list, rather than frequent access.

### HashMap
- Type: Map implementation.
- Order: Unordered; does not maintain insertion order (unless `LinkedHashMap` is used).
- Access Speed: Fast access based on keys (key-value pairs), efficient for locating, inserting, and deleting values based on keys.
- Insertion/Deletion: Efficient for adding and removing key-value pairs.
- Usage: Preferred when elements need to be accessed by keys rather than by sequential index. Ideal for data retrieval based on unique keys.

7. [what is the fail safe and fail fast principle?](#what-is-the-fail-safe-and-fail-fast-principle)
- Fail-Fast: Throws an exception on concurrent modification, ensuring consistency by catching issues early. Examples: ArrayList, HashMap.
- Fail-Safe: Allows concurrent modification without exceptions, iterating over a snapshot. Examples: CopyOnWriteArrayList, ConcurrentHashMap

8. [What is the difference for composite and Inheritance?](#what-is-the-difference-for-composite-and-inheritance)

| Aspect              | Inheritance                      | Composition                      |
|---------------------|----------------------------------|----------------------------------|
| Relationship        | "is-a"                           | "has-a"                          |
| Flexibility         | Less flexible                    | More flexible                    |
| Code Reusability    | Reuses entire class structure    | Reuses specific functionality    |
| Maintenance         | Harder to maintain               | Easier to maintain and test      |
| Examples            | Car extends Vehicle              | Car has Engine                   |

9. [How to make a class immutable?](#how-to-make-a-class-immutable)
- Declare the class as final so that it cannot be subclassed, preventing subclasses from altering its immutability.
- Make all fields private and final to ensure they cannot be modified after object construction.
- Initialize all fields via a constructor to assign values at the time of object creation.
- Avoid providing any "setter" methods that can modify fields or state.
- Ensure deep immutability for fields that are mutable objects (like arrays, collections, or custom mutable objects) by:
- Making defensive copies in the constructor.
- Returning copies (or immutable versions) of mutable fields in "getter" methods to prevent clients from modifying the original data.
- Avoid methods that can change the object’s state.

10. [What are the intermediate and terminal operations in stream api?](#what-are-the-intermediate-and-terminal-operations-in-stream-api)

### Intermediate Operations:
- filter - filter elements based on a predicate
- map - transform elements
- flatMap - flatten nested streams into a single stream
- distinct - remove duplicates
- limit - limit the number of elements
- skip - skip the first n elements
- sorted - sort the elements

### Terminal Operations:
- count - count the number of elements
- sum - sum the elements
- min - find the minimum element
- max - find the maximum element
- forEach - perform an action on each element
- reduce - reduce the elements to a single value

### Collectors:
- groupingBy - group elements based on a function
- partitioningBy - partition elements based on a icate
- summarizing - summarize elements based on a function
- joining - join elements into a single string

# Scenario based Question
1. [For example multi threads reading from cache and one thread writing into cache? how to handle data consistancy?](#for-example-multi-threads-reading-from-cache-and-one-thread-writing-into-cache-how-to-handle-data-consistancy)
- ReadWriteLock: Allows concurrent reads, blocking writes until completion. Best for frequent reads, fewer writes.
- Copy-on-Write: Efficient for read-heavy workloads, as writes create a new copy, but can be memory-intensive.
- ConcurrentHashMap: Best for high-concurrency environments, with fine-grained locking per key segment.
- Immutable Cache and Versioning: Ensures consistency by providing readers a consistent snapshot through versioning, with minimal locking.
- The choice of approach depends on the read-write ratio, data size, and the performance requirements of the application.

# Coding Question
1. [Write a java 8 program to print first non repeated character in a string?](#write-a-java-8-program-to-print-first-non-repeated-character-in-a-string)
```java
    private static Character firstNonRepeatedCharacter(String input) {  
        Character result =  input.chars()           // IntStream
            .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))) // convert to Character
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream()                       // EntrySet stream
            .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
            .map(entry -> entry.getKey())              // get the keys of EntrySet
            .findFirst().get();                        // get the first entry from the keys

        return result;    
    }
```

