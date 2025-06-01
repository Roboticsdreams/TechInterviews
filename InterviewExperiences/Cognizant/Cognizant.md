# Cognizant

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [Cognizant](../Cognizant/Cognizant.md)

# Interview Questions

1. Tell me about yourself
2. Tell me about your projects
3. Tell me about your skills and experience
4. Lesson Learned from your lead role
5. What is your most accomplished achievement in your role? why?

# Coding Question
1. [How to remove the duplicate elements in an array and sort it in descending order?](https://www.geeksforgeeks.org/how-to-remove-the-duplicate-elements-in-an-array-and-sort-it-in-descending-order/)

```java 
    public int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return Arrays.sorted(set.toArray(new Integer[0]), (a, b) -> b - a);
    }
```

# Technical Questions-React
1. What are the react components in react js
2. What are the hooks in react js
3. how to manage state in react js
4. What are the props in react js
5. How to send data from child to parent component in react js

# Technical Questions-Java
1. what the different collections in java
2. what is the difference between arraylist and linkedlist
3. what is the difference between hashmap and hashset
4. what is the difference between array and arraylist
5. In your project which java version you are using

# Technical Questions-Cloud
1. What are the different services in AWS
2. What are the different services which are available in your project
3. What is S3 in AWS
4. What is IAM in AWS
5. What is Auto Scaling in AWS