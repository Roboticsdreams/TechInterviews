# [TechTalks](../README.md) -> [Interview Experiences](./InterviewExp.md) -> [Synechron](./Synechron.md)

## Synechron Interview Experiences
---
1. Performance Optimization for Big Query?

    ![db-query](../assets/db-query.jpg)

    #### 1. Data Optimization
    ##### Partitioning:
    - **Benefits**: Significantly improves query performance by allowing BigQuery to only scan relevant partitions.
    - **Best Practices**: Partition by date or another frequently filtered column.
    ##### Clustering:
    - **Benefits**: Improves query performance for queries with WHERE, GROUP BY, or ORDER BY clauses on clustered columns.
    - **Best Practices**: Cluster by columns frequently used together in queries.
    ##### Data Types:
    - **Benefits**: Using appropriate data types reduces storage costs and improves query performance.
    - **Best Practices**: Choose the smallest data type that can accurately represent your data.
    #### 2. Query Optimization
    ##### Reduce Data Scanned:
    - **Filtering**: Use WHERE clauses to filter data as early as possible in the query.
    - **Projection**: Only select the necessary columns using SELECT. Avoid SELECT ```*.```
    - **Partition Pruning**: Leverage partitioned tables by specifying partition filters in your WHERE clause.
    ##### Efficient Joins:
    - **Join Order**: Join smaller tables first.
    - **Join Types**: Use appropriate join types (e.g., INNER JOIN, LEFT JOIN) based on your data relationships.
    - **Join Predicates**: Use strong join predicates (e.g., equality joins) for faster execution.
    ##### Aggregation:
    - **Grouping**: Use GROUP BY efficiently. Avoid unnecessary grouping.
    - **Aggregation Functions**: Choose appropriate aggregation functions (e.g., COUNT(DISTINCT), APPROX_QUANTILES) for performance.
    ##### Subqueries:
    - **Minimize Subqueries**: Use subqueries judiciously as they can impact performance.
    - **Correlated Subqueries**: Avoid correlated subqueries if possible.
    ##### Query Caching:
    - **Enable Caching**: Enable query caching to reuse results of previously executed queries.
    #### 3. Query Structure and Syntax
    - **Break Down Complex Queries**: Split complex queries into smaller, more manageable subqueries.
    - **Use Common Table Expressions (CTEs)**: Improve readability and maintainability by using CTEs.
    - **Avoid Anti-SQL Patterns**: Be aware of common anti-SQL patterns that can degrade performance.
    ##### 4. BigQuery-Specific Features
    - **Legacy SQL vs. Standard SQL**: Consider using Standard SQL, which offers better performance and more features.
    - **Query Plan**: Analyze the query plan to identify performance bottlenecks.
    - **BigQuery ML**: Utilize BigQuery ML for machine learning tasks within BigQuery.
    ##### 5. Monitoring and Troubleshooting
    - **Query Performance Insights**: Use Query Performance Insights to identify slow queries and analyze their performance.
    - **BigQuery Job Statistics**: Monitor job statistics to track query performance over time.
    - **Resource Limits**: Adjust resource limits (e.g., slots) to optimize query performance.
    Key Takeaways:
    - **Data Optimization**: Proper partitioning and clustering are crucial for performance.
    - **Query Optimization**: Focus on reducing data scanned and writing efficient SQL.
    - **BigQuery Features**: Leverage BigQuery's unique features like Standard SQL and query caching.
    - **Monitoring**: Continuously monitor query performance and identify areas for improvement.

    By following these best practices, you can significantly improve the query execution time in BigQuery and optimize your data analysis workflows.
---
2. Manage the memory leakage in a distributed system using GC in Java?
    - [Blog](https://jelvix.com/blog/java-memory-leak)
    - [Video](https://youtu.be/Ml-jZipUzPk)
    ![memory-leak](../assets/memoryleak.png)

---
3. Java Debuggging techniques
    #### Top 5 Java Debugging Tips
    Debugging is a critical part of the software development process, and there are several ways to debug Java code. Here are some of the most common ways to debug Java code.

    - System.out.println() statements  
    - Debugging with an IDE  
    - Debugging with the command line  
    - Debugging with logging frameworks  
    - Using third-party tools  

    #### 1. System.out.println() Statements
    This is the most basic way to debug Java code. You can insert print statements in your code to output the values of variables and other important information.

    #### Example:
    ```java
    public class Example {
        public static void main(String[] args) {
            int x = 5;
            int y = 7;
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            int sum = x + y;
            System.out.println("sum = " + sum);
        }
    }
    ```
    **Output:**
    ```
    x = 5
    y = 7
    sum = 12
    ```
    When you run this code, it will output the values of `x`, `y`, and `sum`, which can help you verify that your calculations are correct.

    #### 2. Debugging with an IDE
    Integrated development environments (IDEs) such as Eclipse, IntelliJ IDEA, and NetBeans have built-in debugging tools that allow you to set breakpoints in your code, step through the code line by line, and inspect the values of variables and objects.

    In Eclipse, you can set a breakpoint by clicking on the left-hand margin of the line of code where you want to pause execution. Then, when you run the code in debug mode, it will stop at the breakpoint, and you can step through the code using the debug toolbar.

    #### 3. Debugging with the Command Line

    You can also use the command line to debug Java code. The JDK includes a tool called `jdb` (Java Debugger) that allows you to debug code from the command line. Assuming you have the JDK installed, you can use the `jdb` command to debug Java code from the command line.

    #### Example:

    ```java
    public class Example {
        public static void main(String[] args) {
            int x = 5;
            int y = 7;
            int sum = x + y;
            System.out.println("sum = " + sum);
        }
    }
    ```

    To debug this code with `jdb`, you would first compile it with the `-g` option to include debugging information:

    ```bash
    javac -g Example.java
    ```

    Then, you can run `jdb` with the class name:

    ```bash
    jdb Example
    ```

    This will start the `jdb` debugger, and you can use commands like `break`, `step`, and `print` to debug your code.

    #### 4. Debugging with Logging Frameworks

    Logging frameworks such as `log4j` and `java.util.logging` can help you track down bugs by logging information about the execution of your code.

    #### Example using log4j:

    ```java
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    
    public class Example {
        private static final Logger logger = LogManager.getLogger(Example.class);
    
        public static void main(String[] args) {
            int x = 5;
            int y = 7;
            int sum = x + y;
            logger.debug("x = " + x);
            logger.debug("y = " + y);
            logger.debug("sum = " + sum);
        }
    }
    ```

    When you run this code, it will log the values of `x`, `y`, and `sum` to the console, which can help you diagnose any issues.

    #### 5. Using Third-Party Tools

    There are several third-party tools available for debugging Java code, such as JRebel, JProfiler, and VisualVM. These tools can help you identify memory leaks, performance bottlenecks, and other issues in your code.

    #### Example using JProfiler:

    ```java
    import java.util.ArrayList;
    import java.util.List;
    
    public class Example {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 1000000; i++) {
                list.add("item " + i);
            }
            System.out.println(list.size());
        }
    }
    ```

    **Output:**

    ```
    1000000
    ```

    This code creates a large list and adds a million items to it. When you run it in JProfiler, you can use the memory profiling tools to identify any memory leaks or performance issues.

    #### Conclusion
    Overall, the best way to debug Java code will depend on your specific needs and the complexity of the problem you’re trying to solve. It’s always a good idea to use multiple debugging techniques and tools to ensure that you catch all potential issues.
---
4. How to create CI/CD for a project?
    ![CI/CD](../assets/cicd.jpg)
    - [blog](https://dev.to/pavanbelagatti/learn-how-to-setup-a-cicd-pipeline-from-scratch-for-a-go-application-4m69)
    - [video](https://www.youtube.com/watch?v=m0a2CzgLNsc)

    ### **Steps to Create a CI/CD Pipeline for Markdown Files in Jenkins**

    ##### 1. **Install Jenkins**
    - Download and install Jenkins from the [official Jenkins site](https://www.jenkins.io/).
    - Install required plugins:
        - Git Plugin (for pulling Markdown files from repositories).
        - Pipeline Plugin (for defining CI/CD pipelines as code).

    ##### 2. **Set Up a Repository**
    - Store your Markdown files in a version control system like GitHub, GitLab, or Bitbucket.
    - Example repository structure:
        ```
        ├── README.md
        ├── docs/
        │   ├── file1.md
        │   ├── file2.md
        └── Jenkinsfile
        ```

    ##### 3. **Write a Jenkinsfile**
    The `Jenkinsfile` defines the pipeline and contains the steps to validate and process Markdown files.

    **Example Jenkinsfile:**

    ```groovy
    pipeline {
        agent any
        stages {
            stage('Clone Repository') {
                steps {
                    git branch: 'main', url: 'https://github.com/your-repo/markdown-project.git'
                }
            }
            stage('Lint Markdown') {
                steps {
                    echo 'Linting Markdown files...'
                    sh 'npm install -g markdownlint-cli'
                    sh 'markdownlint "**/*.md"'
                }
            }
            stage('Build HTML') {
                steps {
                    echo 'Converting Markdown to HTML...'
                    sh 'pandoc README.md -o output.html'
                }
            }
            stage('Archive Artifacts') {
                steps {
                    echo 'Archiving output...'
                    archiveArtifacts artifacts: 'output.html', onlyIfSuccessful: true
                }
            }
        }
        post {
            always {
                echo 'Pipeline completed.'
            }
            failure {
                echo 'Pipeline failed. Check logs for details.'
            }
        }
    }
    ```

    - **Key Tools Used**:
        - `markdownlint`: Validates Markdown files for style and formatting issues.
        - `pandoc`: Converts Markdown files to other formats like HTML.

    ##### 4. **Create a New Jenkins Pipeline**
    - Go to Jenkins Dashboard.
    - Click **New Item** > **Pipeline**.
    - Name the job and select "Pipeline" type.
    - In the Pipeline section:
        - Select "Pipeline script from SCM."
        - Choose your Git repository and specify the `Jenkinsfile` path.

    ##### 5. **Run the Pipeline**
    - Click **Build Now** to trigger the pipeline.
    - Verify the stages (e.g., clone repository, lint Markdown, convert to HTML) run successfully.

    ##### 6. **Monitor and Debug**
    - View logs in the Jenkins console output.
    - Fix any issues reported by `markdownlint` or errors during the conversion process.

    ##### 7. **Optional: Add Notifications**
    - Use plugins like Email Extension or Slack Notification to send build status alerts to your team.

    This setup ensures Markdown files are validated, processed, and their outputs archived. You can adapt the pipeline to include additional stages like deployment or publishing documentation. Let me know if you'd like more details on any step!
---
5. How to run a JProfiler?

    To run JProfiler and profile a Java program 

    #### **1. Write a Java Program**
    Create a simple Java program that generates 100,000 random values.

    ```java
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;

    public class RandomValuesProfiler {
        public static void main(String[] args) {
            List<Integer> randomValues = new ArrayList<>();
            Random random = new Random();

            // Generate 100,000 random values
            for (int i = 0; i < 100000; i++) {
                randomValues.add(random.nextInt(1000000));
            }

            // Process the random values (e.g., sort them)
            randomValues.sort(Integer::compareTo);

            System.out.println("Processed " + randomValues.size() + " random values.");
        }
    }
    ```
    #### **2. Compile the Java Program**
    Compile the program with debugging information enabled (`-g` flag):

    ```bash
    javac -g RandomValuesProfiler.java
    ```
    #### **3. Install and Launch JProfiler**
    1. Download and install JProfiler from the [official website](https://www.ej-technologies.com/products/jprofiler/overview.html).
    2. Open JProfiler and create a new session:
    - Go to **Session > New Session**.
    - Choose **Application** as the session type.
    #### **4. Configure JProfiler for Your Application**
    1. In the **Session Startup** window:
    - **Select Executable JAR or Main Class**:
        - If you compiled the program into a `.class` file, select `RandomValuesProfiler` as the main class.
    - **Configure JVM**:
        - Use the default JVM provided or select your Java version.
    - Add JVM arguments if needed (e.g., `-Xmx512m` for memory).

    2. Add any custom classpath if required (e.g., directories containing dependencies).

    #### **5. Run the Program with JProfiler**
    1. Click **Start** in JProfiler to launch your application.
    2. JProfiler will attach itself to the program as it runs.

    #### **6. Analyze the Profiling Results**
    Once the program runs, use JProfiler to analyze different performance aspects:

    1. **CPU Profiling**:
    - Go to the CPU view to see which methods consumed the most time (e.g., `random.nextInt()` and `randomValues.sort()`).

    2. **Memory Profiling**:
    - Check memory usage and garbage collection activity while generating and sorting random values.

    3. **Thread Activity**:
    - Observe the thread responsible for executing the random value generation.

    4. **Heap Usage**:
    - Monitor how much memory is being used by the `ArrayList` storing the 100,000 random values.

    #### **7. Optimize the Program**
    Based on JProfiler's insights:
    - **Improve Memory Usage**:
    - Preallocate the size of the `ArrayList`:
        ```java
        List<Integer> randomValues = new ArrayList<>(100000);
        ```
    - **Reduce CPU Overhead**:
    - Optimize the sorting algorithm if necessary or experiment with alternative data structures.

    #### **8. Save and Review Profiling Reports**
    1. Export the profiling session data for later analysis:
    - Go to **File > Export Data**.
    2. Share reports with your team or use them for further debugging.

    #### **Conclusion**
    By following these steps, you can profile the performance of your Java program that generates and processes 100,000 random values. JProfiler provides insights into CPU usage, memory allocation, and application efficiency, allowing you to optimize performance effectively. Let me know if you need help with any of the steps!