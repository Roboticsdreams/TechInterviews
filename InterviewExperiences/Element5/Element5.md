# Element5

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [Element5](../Element5/Element5.md)

# Interview Questions
1. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

```java
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
```
2. Any two design patterns with real-world examples?

```java
    - Singleton design pattern
    - Factory design pattern

    Singleton design pattern:
    public class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    Factory design pattern:
    public class Factory {
        public static Product createProduct(String type) {
            if (type.equals("A")) {
                return new ProductA();
            } else if (type.equals("B")) {
                return new ProductB();
            } else {
                throw new IllegalArgumentException("Invalid product type");
            }
        }
    }
```
3. What is polymorphism? and types of polymorphism?
```java
    Polymorphism:
     - Polymorphism is the ability of an object to take many forms.
     - Polymorphism is achieved through inheritance.
     - They are two types of polymorphism:
     - Compile time polymorphism
     - Runtime polymorphism

    Compile time polymorphism:
    - Method overloading
        methods with same name but different parameters

    public class Animal {
        public void eat() {
            System.out.println("Eating");
        }

        public void eat(String food) {
            System.out.println("Eating " + food);
        }
    }

    public class Dog extends Animal {
        public void eat() {
            System.out.println("Eating");
        }
    }

    public class Cat extends Animal {
        public void eat(String food) {
            System.out.println("Eating " + food);
        }
    }

    public class Zoo {
        public static void main(String[] args) {
            Animal animal = new Animal();
            Animal dog = new Dog();
            Animal cat = new Cat();

            animal.eat();
            dog.eat();
            cat.eat("Meat");
        }
    }

    Output:
    Eating
    Eating
    Eating Meat

    Runtime polymorphism:
    - Method overriding
        methods with same name and same parameters but different return type

    public class Animal {
        public void eat(int times) {
            System.out.println("Eating " + times + " times");
        }

        public void eat(String food) {
            System.out.println("Eating " + food);
        }
    }

    public class Dog extends Animal {
        public void eat(int times) {
            System.out.println("Eating " + times + " times");
        }
    }

    public class Cat extends Animal {
        public void eat(String food) {
            System.out.println("Eating " + food);
        }
    }

    public class Zoo {
        public static void main(String[] args) {
            Animal dog = new Dog();
            Animal cat = new Cat();
            dog.eat(3);
            cat.eat("Meat");
        }
    }

    Output:
    Eating 3 times
    Eating Meat
```

4. Any 5 AWS services? and their uses?
```java
    - AWS Lambda
    - Amazon RDS
    - Amazon DynamoDB
    - Amazon S3
    - Amazon EC2

    AWS Lambda:
    - Lambda is a serverless computing service that runs on AWS and is designed to scale automatically.
    - It is a compute service that runs code in response to events without provisioning or managing servers.
    - You only pay for the compute time you use.

    Amazon RDS:
    - Relational Database Service
    - Database

    Amazon DynamoDB:
    - DynamoDB is a fully managed NoSQL database service that provides fast and predictable performance with low latency.

    Amazon S3:
    - Amazon Simple Storage Service
    - Storage

    Amazon EC2:
    - Elastic Compute Cloud
    - Compute
```

