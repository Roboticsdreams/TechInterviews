# LTIMindtree

[Tech-Interviews](../../README.md) -> [Experiences](../Experiences.md) -> [LTIMindtree](../LTIMindtree/LTIMindtree.md)

# Question Bank
- [QuestionBank](../LTIMindtree/QuestionBank.md)

# Interview Questions
- Hashmap internal working
- Design patterns 
- Solid principles
- IOC vs dependency injection 
- Microservies orchestrator vs microservices choreography 
- Acid principles at DBMS
- At transactional annotations
- Java 8 function Interface
- Predicates, function, bifuncation
- Map vs flatmap in java
- How to create custom exception in java

# Coding Question
- [How to check if given strings are anagrams?](#how-to-check-if-given-strings-are-anagrams)

```java
public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    return Arrays.equal(s.chars().sorted().toArray(),  t.chars().sorted().toArray());
}
```