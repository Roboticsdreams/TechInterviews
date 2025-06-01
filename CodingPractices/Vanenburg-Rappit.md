# Vanenburg-Rappit

[Tech-Interviews](../README.md) -> [References](../References.md) -> [InterviewPreparations](../InterviewPreparations/InterviewPreparations.md) -> [Vanenburg-Rappit](Vanenburg-Rappit.md)

# 1. Technical Questions
## 1.1 Object-Oriented Programming (OOP):
- Explain inheritance, polymorphism, and encapsulation with real-world implementations.

#### Inheritance: 
- Inheriting properties and methods from a parent class to a child class.
- use implements interface - only one class
- use extends class - multiple classes

#### Inheritance Example:
```java
class Vehicle {
    private int wheels; // Parent class field for wheels

    // Constructor to set wheels
    public Vehicle(int wheels) {
        this.wheels = wheels;
    }

    // Getter method for wheels
    public int getWheels() {
        return wheels;
    }
}

// Car class inherits from Vehicle
class Car extends Vehicle {
    public Car() {
        super(4); // Call the parent constructor to set wheels to 4
    }
}

// Bike class inherits from Vehicle
class Bike extends Vehicle {
    public Bike() {
        super(2); // Call the parent constructor to set wheels to 2
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        Bike b = new Bike();

        // Print the number of wheels for each vehicle
        System.out.println("Car has " + c.getWheels() + " wheels.");
        System.out.println("Bike has " + b.getWheels() + " wheels.");
    }
}

Output:
Car has 4 wheels.
Bike has 2 wheels.
```
#### Types of Inheritance:
- Single Inheritance
- Multiple Inheritance
- Multilevel Inheritance
- Hierarchical Inheritance
- Hybrid Inheritance

#### Polymorphism:
Polymorphism: ablity to handle multiple forms of an object.
- compile time polymorphism - same method diff no of args
- run time polymorphism - same method diff return type

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Shape();
        Shape shape2 = new Circle();
        Shape shape3 = new Rectangle();

        shape1.draw(); // Output: Drawing a shape
        shape2.draw(); // Output: Drawing a circle
        shape3.draw(); // Output: Drawing a rectangle
    }
}
```
#### Encapsulation: 
wrapping data and methods in a single unit.
- data hiding
- data abstraction

Key Differences:

| Feature         | Data Hiding                                      | Data Abstraction                                  |
|-----------------|--------------------------------------------------|--------------------------------------------------|
| **Focus**       | Restricts direct access to internal details.     | Hides implementation details of functionality.   |
| **Achieved By** | Using private and controlled methods (getters, setters). | Using abstract classes or interfaces.           |
| **Example Usage** | Sensitive fields like balance in a bank account. | Generalized behavior like calculating the area of shapes. |

```java
class BankAccount {
    private String name; // private field cannot be accessed directly
    private int balance; // private field cannot be accessed directly

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getbalance() {
        return balance;
    }

    public void setbalance(int balance) {
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setName("John Doe");
        account.setbalance(1000);

        System.out.println("Name: " + account.getName());
        System.out.println("Balance: " + account.getbalance());
    }
}
```
- Pseudocode for classes and objects:
```pseudocode
Class Person
  Properties:
    name - string
    age - integer

  Methods:
    constructor(name, age)
      Set name to name
      Set age to age
    getDetails()
      Return name and age
  
Object person1
  Call Person constructor with name "John Doe" and age 25
  Print person1.getDetails() // Output: John Doe, 25
```
- Factory design pattern with an example.

  Factory design pattern is a creational design pattern in software engineering that provides a way to create objects without specifying the exact class of the object to be created. It allows you to encapsulate object creation logic in a separate class, making it easy to add new object types or modify existing ones without modifying the client code.

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equals("circle")) {
            return new Circle();
        } else if (type.equals("rectangle")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("circle");
        Shape rectangle = ShapeFactory.createShape("rectangle");

        circle.draw(); // Output: Drawing a circle
        rectangle.draw(); // Output: Drawing a rectangle
    }
}
```
- What is the difference between an interface and an abstract class? When do we use them?
  
| Feature                | Interface                                                   | Abstract Class                                           |
|------------------------|------------------------------------------------------------|---------------------------------------------------------|
| **Purpose**            | To define a contract for implementing classes.             | To provide a base class with some implemented methods.  |
| **Methods**            | Can only have abstract methods (default and static methods in modern Java). | Can have both abstract and concrete methods.            |
| **Fields**             | Can only have public, static, and final fields (constants). | Can have instance variables (not necessarily static or final). |
| **Inheritance**        | A class can implement multiple interfaces.                 | A class can inherit only one abstract class.            |
| **Access Modifiers**   | Methods in an interface are implicitly public.             | Methods can have any access modifier (public, protected, private). |
| **When to Use**        | Use when you want to define a contract for unrelated classes. | Use when you want to share code among related classes.  |
| **Example**            | `public interface Flyable { void fly(); }`                 | `public abstract class Animal { abstract void sound(); }` |

## 1.2 Data Structures and Algorithms (DSA):
- Maximum subarray sum (Kadane's Algorithm).
  Kadane's algorithm is a dynamic programming algorithm that efficiently finds the maximum subarray sum in an array. It works by keeping track of the current maximum subarray sum and the current subarray sum at each index.

```java
import java.util.Arrays;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Call the method to find the max subarray sum and print the result
        findMaxSubarraySum(arr);
    }

    public static void findMaxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE; // To track the maximum sum
        int currentSum = 0;            // To track the current sum
        int start = 0, end = 0;        // Indices for the subarray
        int tempStart = 0;             // Temporary start index

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // If currentSum drops below 0, reset it and update tempStart
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }

            // If the current sum is greater than the max sum, update maxSum and indices
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Print the maximum sum and the subarray
        System.out.println("Maximum Subarray Sum: " + maxSum);
        System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
    }
}
```
- Dining Philosophers problem.

    The Dining Philosophers Problem is a classic synchronization problem that demonstrates issues like deadlock, starvation, and concurrency in a multi-threaded environment.

    Problem Description:

    - Five philosophers are seated around a circular table.
    - Each philosopher alternates between thinking and eating.
    - They require two forks (or chopsticks) to eat but can only pick up one at a time.
    - There are only five forks available, one between each pair of philosophers.

 Solution:
    - Use a strategy such as picking up forks in a particular order.
    - Introduce a timeout for picking up forks.
    - Use locks to manage synchronization.
    - Below is a Java solution using threads and ReentrantLock.

 Code Implementation:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    // Number of philosophers
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Lock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];

        // Initialize forks
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        // Initialize philosophers and start their threads
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            // Philosophers are numbered 0 to NUM_PHILOSOPHERS - 1
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUM_PHILOSOPHERS]);
            new Thread(philosophers[i], "Philosopher " + i).start();
        }
    }
}

class Philosopher implements Runnable {
    private int id;
    private Lock leftFork;
    private Lock rightFork;

    public Philosopher(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        // Pick up the left fork
        leftFork.lock();
        try {
            System.out.println("Philosopher " + id + " picked up the left fork.");

            // Pick up the right fork
            rightFork.lock();
            try {
                System.out.println("Philosopher " + id + " picked up the right fork and is eating.");
                Thread.sleep((long) (Math.random() * 1000));
            } finally {
                // Put down the right fork
                rightFork.unlock();
                System.out.println("Philosopher " + id + " put down the right fork.");
            }
        } finally {
            // Put down the left fork
            leftFork.unlock();
            System.out.println("Philosopher " + id + " put down the left fork.");
        }
    }
}
```
   Explanation:

Using Forks as Locks:

- Each fork is represented by a ReentrantLock.
- Philosophers pick up the left and right forks using lock().
    
Avoiding Deadlock:
- Philosophers pick up the left fork first and then the right fork.
- Deadlock is avoided by controlling the order of fork acquisition.

Thinking and Eating:
- Philosophers alternate between thinking (simulated with Thread.sleep()) and eating.

Multithreading:
- Each philosopher runs in its own thread.

Sample Output:
```text
Philosopher 0 is thinking.
Philosopher 1 is thinking.
Philosopher 2 is thinking.
Philosopher 0 picked up the left fork.
Philosopher 0 picked up the right fork and is eating.
Philosopher 1 picked up the left fork.
Philosopher 0 put down the right fork.
Philosopher 0 put down the left fork.
Philosopher 1 picked up the right fork and is eating.
```
Notes:

Starvation: This solution reduces the chance of starvation but does not completely eliminate it.

Concurrency: Multiple philosophers can think and eat concurrently.

Improvements: Introduce a priority mechanism or timeout to further minimize starvation. Use a waiter process to enforce fork availability rules.


## 1.3. Database (DBMS):
- Explain ACID properties and their importance.

| **Property**       | **Description**                                                                                   | **Importance**                                                                                      | **Example**                                                                                                                                                  |
|---------------------|---------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Atomicity**       | Ensures that a transaction is treated as a single, indivisible unit: either **all** operations succeed or **none**. | Prevents incomplete operations from corrupting the database.                                        | A bank transfer: If $100 is debited from Account A but not credited to Account B, the transaction should roll back to maintain consistency.                  |
| **Consistency**     | Guarantees that a transaction brings the database from one valid state to another.                | Ensures that database constraints (e.g., foreign keys, unique constraints) are not violated.        | Transferring money: The total balance in all accounts should remain the same before and after a transfer, maintaining financial consistency.                 |
| **Isolation**       | Ensures that concurrent transactions do not interfere with each other.                            | Avoids conflicts and ensures accurate results in multi-user environments.                          | Two users purchasing the last item in an inventory at the same time: Proper isolation ensures only one purchase succeeds, preventing data corruption.         |
| **Durability**      | Guarantees that once a transaction is committed, it remains so, even in the event of a system failure. | Protects data integrity and ensures transactions are permanently stored.                            | After confirming a flight booking, the booking should remain in the database even if the system crashes immediately after confirmation.                      |

- Write an SQL query to find the top 5 customers with the highest total order amounts for each month.
```sql
    WITH RankedOrders AS (
    SELECT
        c.customer_id,
        c.customer_name,
        SUM(o.order_amount) AS total_order_amount,
        EXTRACT(YEAR FROM o.order_date) AS order_year,
        EXTRACT(MONTH FROM o.order_date) AS order_month,
        ROW_NUMBER() OVER (PARTITION BY EXTRACT(YEAR FROM o.order_date), EXTRACT(MONTH FROM o.order_date) ORDER BY SUM(o.order_amount) DESC) AS rank
    FROM
        customers c
    JOIN
        orders o ON c.customer_id = o.customer_id
    GROUP BY
        c.customer_id, c.customer_name, EXTRACT(YEAR FROM o.order_date), EXTRACT(MONTH FROM o.order_date)
)
SELECT
    customer_id,
    customer_name,
    total_order_amount,
    order_year,
    order_month
FROM
    RankedOrders
WHERE
    rank <= 5
ORDER BY
    order_year DESC,
    order_month DESC,
    rank;
```
- Design a database schema for a college Bus Management System.
```sql
- Student (student_id, first_name, last_name, roll_number, email, contact_number, address, bus_id)
- Bus (bus_id, bus_number, capacity, driver_id, route_id) 
- Bus_Schedule (schedule_id, bus_id, route_id, departure_time, arrival_time, day_of_week)
- Route (route_id, route_name, starting_point, destination, distance_km) 
- Bus_Stop (stop_id, bus_id, location_name, latitude, longitude)
- Bus_Fare (fare_id, route_id, fare_amount, valid_from, valid_to)
- Bus_Maintenance (maintenance_id, bus_id, maintenance_type, maintenance_date, next_service_due)
- Driver (driver_id, first_name, last_name, phone_number, email, license_number)
- Attendance (attendance_id, student_id, schedule_id, attendance_date, status)
```
- Design an employee database schema.
```sql
-Employee (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, department_id, salary_id, manager_id)
- Job (job_id, job_title, min_salary, max_salary)
- Department (department_id, department_name, location)
- Salary (salary_id, base_salary, bonus, tax_deduction)
- Attendance (attendance_id, employee_id, attendance_date, status)
- Payroll (payroll_id, employee_id, payroll_date, gross_salary, net_salary, bonus, tax_deduction)
- Leave (leave_id, employee_id, leave_type, leave_start_date, leave_end_date, leave_status)
- Employee_Project (employee_id, project_id, role, start_date, end_date)
- Project (project_id, project_name, start_date, end_date, budget)
```

## 1.4. Web Technologies:
- What is JavaScript, and who invented it?
- Closures in JavaScript.
- Semantic HTML.
- React lifecycle methods.
- CSS properties: Specificity, Position, Display.

## 1.5. Spring Boot and Java:

### **What is Spring Boot, and which version do you use?**
Spring Boot is a framework for building Spring applications. It provides a convenient way to start a Spring application and simplify the configuration process.

### **Version: Spring Boot 3.0.0**

#### Key Differences Between **Spring Boot 3.0.0** and Previous Versions

#### 1. **Java 17+ Requirement**
   - **Spring Boot 3.0.0** requires **Java 17** or later, removing support for Java 8 and Java 11 (which were supported in previous versions like 2.x).
   - **Previous Versions**: Java 8 and Java 11 were still supported.

#### 2. **Spring Framework 6.x**
   - **Spring Boot 3.0.0** is built on **Spring Framework 6.x**, which introduces:
     - **Java 17+ baseline**: New minimum Java version is 17.
     - **New Jakarta EE 9 APIs**: Packages like `javax` are replaced with `jakarta` (e.g., `javax.persistence` → `jakarta.persistence`).
   - **Previous Versions**: Based on **Spring Framework 5.x**, using `javax` APIs.

#### 3. **Jakarta EE Migration**
   - **Spring Boot 3.0.0** supports **Jakarta EE 9** and the **Jakarta namespace** (i.e., all dependencies that used the `javax.*` namespace are now migrated to `jakarta.*`).
   - **Previous Versions**: Used the `javax.*` namespace for Jakarta EE-related functionality.

#### 4. **Removed Deprecated Features**
   - **Spring Boot 3.0.0** removes several deprecated features, configurations, and properties that were available in Spring Boot 2.x.
   - **Previous Versions**: Supported deprecated features for backward compatibility.

#### 5. **GraalVM Native Image Support**
   - **Spring Boot 3.0.0** introduces better support for **GraalVM Native Images** with improved native compilation capabilities.
   - **Previous Versions**: GraalVM support was available but with more limited configurations.

#### 6. **Updated Dependencies and Libraries**
   - **Spring Boot 3.0.0** includes **updated dependencies** (e.g., Spring Data, Spring Security, and Spring Cloud).
   - **Previous Versions**: Older versions had dependencies compatible with Java 8/11 and Spring 5.x.

#### 7. **Configuration Changes**
   - **Spring Boot 3.0.0** introduces configuration changes related to `jakarta.*` packages, and some properties have changed names or been removed.
   - **Previous Versions**: Configuration was based on `javax.*` and older property names.

#### 8. **Kotlin Support**
   - **Spring Boot 3.0.0** improves support for **Kotlin** and provides better integration with Kotlin-based projects, especially for using new Kotlin features.
   - **Previous Versions**: Kotlin support was available but less mature compared to Spring Boot 3.0.0.

#### 9. **Web and Reactive Improvements**
   - **Spring Boot 3.0.0** brings enhancements to **Spring Web** and **Spring WebFlux** (reactive web support).
   - **Previous Versions**: Web and reactive support was available but has been enhanced in 3.0.0 for better performance and compatibility with newer Java versions.

#### 10. **Improved Documentation and Developer Experience**
   - **Spring Boot 3.0.0** has improved **developer experience** with better documentation, more examples, and greater clarity on new features and breaking changes.
   - **Previous Versions**: Documentation was comprehensive but not as focused on the latest Java features.

#### 11. **Support for Newer Versions of Database Drivers and Frameworks**
   - **Spring Boot 3.0.0** includes support for the latest versions of popular database drivers and frameworks like Hibernate, JDBC, and others.
   - **Previous Versions**: Supported older versions of these drivers and frameworks.

#### 12. **New Dependencies and Spring Modules**
   - **Spring Boot 3.0.0** introduces **new modules** and capabilities for specific integrations like observability (metrics, tracing, etc.).
   - **Previous Versions**: Had a different set of integrations and APIs.

### **The use of the @Transactional annotation**

The @Transactional annotation is used to manage transactions in Spring Boot applications. It is a part of the Spring Framework and is used to specify the transactional behavior of a method or class.

```java
@Transactional
public class UserService {

    @Transactional
    public void createUser(User user) {
        // Code to create the user
    }

    // Other methods
}
```



# 2. Non-Technical Questions
- Tell me about yourself.
- Where do you see yourself in 5 years?
- Are you ready to work with a completely different platform?

# 3. Coding Problems
- Write a code to reverse a string.
- Program to delete consecutive nodes from a linked list.
- Code to find missing and repeated numbers in an array of length 100 in O(N) complexity.
- Find the frequency of a given character in a string.
- Write code for a binary tree (e.g., right binary tree).
- Find Triplets with a given sum in an array.
- Reverse an array in O(n) complexity.
- Program to delete the nth node of a linked list.
- Find the second-largest number in an array.
- Sorting algorithms (Quick Sort, Bubble Sort, Merge Sort, Insertion Sort).
- Rearrange an array to move 0s to the left and 1s to the right.
- Identify duplicate and missing numbers in an array in O(n) complexity.
- Age calculation problem.
- Program to find the Kth largest and Kth smallest number in an array.
- Write a code to find the median of a stream of numbers.
- Fibonacci series (Nth Fibonacci Number).
- Program to find the sum of all left leaves in a binary tree.

# 4. Logical Puzzles
- Tomatoes and tolls puzzle.
- Ducks puzzle: Two ducks in front, two behind, and one in the middle.

# 5. System Design
- High-level design of an Expense Management Tracker.