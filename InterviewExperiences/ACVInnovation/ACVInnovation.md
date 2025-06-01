# ACVInnovation

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [ACVInnovation](../ACVInnovation/ACVInnovation.md)

# Round -1
# Coding Questions

1. [How to count number of files in given directory using Recursion?](#how-to-count-number-of-files-in-given-directory-using-recursion?)
```java
String[] directoryStructure = {
 "root",          // root directory
 "folder1",      // subdirectory
 "file1.txt",    // file in folder1
 "file2.txt",    // another file in folder1
 "folder2",      // another subdirectory
 "file3.txt",    // file in folder2
 "folder3",      // another subdirectory
 "file4.txt",    // file in folder3
 "folder4"       // empty subdirectory
 };
 output = 4 // number of files in directories and subdirectories
```

```java
    public static int recursiveFileCount(String[] path, int length, int count) {
        if (length > 0) {
            count += path[length-1].contains(".txt") ? 1: 0;
            count = recursiveFileCount(path, length-1, count);
        }
        return count;
    }

    recursiveFileCount(directoryStructure, directoryStructure.length, 0);
 ```
2. [How to get the emp name and manager name for each employee using employee table?](#how-to-get-the-emp-name-and-manager-name-for-each-employee-using-employee-table?)

```sql
Table structure: empid, ename, managerid;

select 
    t1.empid, t1.ename, t1.managerid, t2.ename 
from 
    employee t1, 
    employee t2 
where
    t1.managerid = t2.empid 
    or t1.managerid is null;
```

# Round -2
# System Design 
1. Music Streaming System
   Lets consider, we have a music streaming system with following features

   - User can create an account
   - User can login
   - User can play music
   - User can add music to playlist
   - User can view playlist
   - User can view all music
   - User can view all playlist

   We are consider to use mutiple server for this system. what is the advantage and disadvantage of using multiple server?

```sql
   - Advantages
     User can play music and add music to playlist from any server. 
     If multiple server even one server down other server can play music.
     We can connect nearby server and play music for faster streaming and better quality.
     Better manage the service traffic using load balancer.

   - Disadvantages
     It will increase the complexity of the system.
     It will increase the latency of the system.
     It will increase the cost of the system.
```

2. How to build a REST API Service better? 
    - What are the necessary components to build a REST API Service? 
    - How to identify the performance degradation? 
    - How to fix the performance degradation? 
    - How to proactive detect and fix the performance degradation?

```sql
    REST API Service includes
    - Client
    - Controller
    - Service
        - Bean
        - Service Interface
        - Service Implementation
    - Model
    - Repository
    - Database

    Performance degradation
    - High latency
    - High response time
    - High memory usage
    - High CPU usage
    - High disk usage

    Proactive detect and fix the performance degradation
    - Monitor the performance metrics
    - Identify the root cause of the performance degradation
    - Fix the root cause of the performance degradation
    - Monitor the performance metrics after the fix

    Steps to fix the performance degradation
     - use load balancer
     - use caching
     - use rate limiter
     - use circuit breaker
     - use logging
     - use monitoring
```

3. Reverse Sentence Code Review

problem

A function was written by a colleague that takes a string and reverses the order of the words

Example
'the brown dog jumped over the lazy programmer' -> 'programmer lazy the over jumped dog brown the'

```java
public class Main {
    public static void main(String[] args) {
        String t = "this is my test";
        System.out.println(reverseWordOrder(t));
    }

    public static String reverseWordOrder(String t) {
        final String theAnswer = "";
        String[] ts = t.split(" ");
        for (int i=0; i< ts.length; i++) {
            theAnswer += ts[i]+ " ";
        }
        return theAnswer;
    }
}
```

Code Review Comments:
 - Proper naming of variables
 - Proper indentation and comments
 - Use of proper data types for variables
 - Use of proper return type
 - Use of proper exception handling
 - No duplicate code
 - Code is clean
 - Complexity should be less than 10
 - Proper design of logic
 - Validated test cases include edge cases

```java
    public static String reverseWordOrder(String input) {
        String result = "";

        #split input into words
        String[] words = input.split(" ");

        #reverse words using for loop
        for (int i = words.length-1; i > 0; i--) {
            result += words[i] + " ";
        }

        #add first word
        result += words[0];

        return result;
    }
```

4. Coding Question - Price Check

Description

There is a shop with old style cash registers. Rather than scanning items and pulling the price from a database, the price
of each item is typed in manually, this method sometimes leads to errors. Given a list of items and their correct prices, 
compare the prices to those entered when each item was sold. Determine the number of errors in selling prices.

Example:
- products = ['eggs','milk','cheese']
- productPrices = [2.89,3.29,5.79]
- productSold = ['eggs','eggs','cheese','milk']
- soldPrice=[2.89,299,5.97,3.29]

```sql
product Actual Expected Error
eggs 	2.89	2.89 
eggs	2.99	2.89	1
cheese	5.97	5.79	1
milk	3.29	3.29	
```
```java
public static int priceCheck(
    String[] products, 
    double[] productPrices, 
    String[] productSold, 
    double[] soldPrice) {

    int errorCount = 0;
    Map<String, Double> productMap = new HashMap<>();
    for (int i = 0; i < products.length; i++) {
        productMap.put(products[i], productPrices[i]);
    }
    for (int i = 0; i < productSold.length; i++) {
        double price = (double) productMap.get(productSold[i]);
        if (price != soldPrice[i]) {
            errorCount++;
        }
    }

    return errorCount;
}
```
5. what is Kafka? How to use Kafka? 
    - How to design a Kafka Producer? 
    - How to design a Kafka Consumer? 
    - How to design Event Driven Architecture?

```sql
    Event Driven Architecture
    Kafka
    Kafka Producer
    Kafka Consumer

    Event Driven Architecture
    - Event
    - Event Listener
    - Event Dispatcher
    - Event Handler

    Kafka
    - Producer
    - Consumer
    - Topic
    - Partition
    - Offset
    - Message
    - Producer
    - Consumer
    - Topic

    Kafka Producer
    - send
    - sendAsync

    Kafka Consumer
    - subscribe
    - poll
    - poll(Duration duration)
    - subscribe(List<String> topics)
    - subscribe(List<String> topics, ConsumerRebalanceListener consumerRebalanceListener)
    - assign(Collection<TopicPartition> partitions)
    - seek(TopicPartition partition, long offset)
    - seek(TopicPartition partition, OffsetAndMetadata offsetAndMetadata)
    - seekToBeginning(Collection<TopicPartition> partitions)
    - seekToEnd(Collection<TopicPartition> partitions)
    - position(TopicPartition partition)
    - position(TopicPartition partition, OffsetSpec offsetSpec)
    - committed(TopicPartition partition)
    - committed(TopicPartition partition, OffsetSpec offsetSpec)
    - committed(OffsetSpec offsetSpec)
    - committed()
    - committed(TopicPartition partition, OffsetSpec offsetSpec)

```