# Payoda

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [Payoda](../Payoda/Payoda.md)

# Interview Questions

1. what is the difference between react dom and bom?
```java
    dom - document object model, dom is a part of the web api
    bom - browser object model, bom is a part of the window object
```
2. what is the lifecycle of a react component?
```java
    Mounting
    Updating
    Unmounting
```
3. what is the use of react hooks?
```java
    useState
    useEffect
    useContext
    useReducer
    useMemo
    useCallback
```

4. what the use of useeffect in react?
```java
    useEffect
    - useeffect is used to perform side effects in functional components like fetching data from an API, updating the DOM, and subscribing to events.
    - Types of useEffect:    
    -> useEffect(callback)
    -> useEffect(callback, [])
    -> useEffect(callback, [dependencies])
    -> useEffect(callback, [dependencies1, dependencies2, ...])
```
5. write a react project to send the data from parent to child component? and send the data from child to parent component?
```react
    import React, { useState } from 'react';

    const Parent = () => {
        const [data, setData] = useState(0);

        return (
            <div>
                <h1>{data}</h1>
                <button onClick={() => setData(data + 1)}>Increment</button>
                <Child data={data} />
            </div>
        );
    };

    const Child = ({ data }) => {
        return (
            <div>
                <h1>{data}</h1>
            </div>
        );
    };

    export default Parent;

    import React, { useState } from 'react';

    const App = () => {
        const [data, setData] = useState(0);

        return (
            <div>
                <h1>{data}</h1>
                <button onClick={() => setData(data + 1)}>Increment</button>
                <Parent data={data} />
            </div>
        );
    };

    export default App;
```
6. write a program to find the second largest element in array without sorting
```java
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,7,6};

        int largest = arr[0];
        int secondLargest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        System.out.println(secondLargest);
    }
```

7. What is connection pool and its uses?
```sql
   - connection pool is used to reduce the number of connections required to execute a query.
   - it increases the performance of the application by reusing the same connection for multiple queries.
   - it is also used to manage the load on the database server.
```

8. what is functional and callable interface in java?
```java
    - functional interface
     - interface which contains only one abstract method.
     - usually used with lambda expressions.
     
    - callable interface
     - contains both abstract and non-abstract methods.
     - usually used with threads.

     example:
     public interface Callable<V> {
        V call() throws Exception;
     }

     public class MyCallable implements Callable<String> {
        public String call() {
            return "Callable Interface Example";
        }
     }

     public static void main(String[] args) throws Exception {
        Callable<String> callable = new MyCallable();
        String result = callable.call();
        System.out.println(result);
     }


    -functional interface:
    public interface Function<T, R> {
        R apply(T t);
    }

    public class MyFunction implements Function<String, Integer> {
        public Integer apply(String s) {
            return s.length();
        }
    }

    public static void main(String[] args) {
        Function<String, Integer> function = new MyFunction();
        Integer result = function.apply("Hello");
        System.out.println(result);
    }
```

9. what is difference between controller and rest controller?
```java
Controller
    Used to create common web controllers that return HTTP responses and views, such as HTML pages. Controllers are best for UI-based applications that require rendering HTML templates. They are created using the @Controller annotation.
RestController
    Used to create controllers for REST APIs that return JSON responses. RestControllers are best for returning data, such as JSON or XML, rather than a view. They are created using the @RestController annotation, which is a combination of the @Controller and @ResponseBody annotations.
```

10. Is it possible to create a try catch without catch block?
```java
    Yes, it is possible to create a try catch without catch block.

    Example:
    try {
        system.out.println("Hello");
        throw new Exception();
    }
    finally {
        system.out.println("Bye");
    }
```

11. what is the volatile keyword in java?
```java
    - volatile keyword is used to make a variable volatile.
    example:
    public class MyThread extends Thread {
        private volatile boolean running = true;

        public void run() {
            while (running) {
                // do something
            }
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.stop();
    }
```