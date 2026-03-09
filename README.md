[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/w208pGd4)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=22977792&assignment_repo_type=AssignmentRepo)
# Assignment 2: DI and AOP

In this assignment, you will _**first**_ use Spring Boot Framework to wire up some services used by a “web application”
and _**second**_ use Spring AOP framework to create logging aspect. 
This is NOT a real web application, it is just a conceptual application to help you understand the usage of Dependency Injection. 

The services and their dependencies are as follows:
* `WebApplication` _depends_ on a `WebServer` to run its application logic. 
* `WebServer` _depends_ on a `Frontend`, a `Middleware` and a `Persistence` services. There are a couple of implementations for each of these services. 
* `Frontend` _depends_ on an `Authentication` service. There are a couple of implementations for this service. 

<!-- Trigger workflow to test enhanced detailed feedback -->
* `Persistence` _depends_ on a `FileSystem` and a `Connection` service. There are a couple of implementations for each of these services.

## Tasks 

1. **Task 1 (15 points)**: You will use Constructor Injection to wire up these services as described above for each of the implementations. 
For each service, in the run() method you will invoke all of the dependent services if there are any (similar to WebServer). 

1. **Task 2 (15 points)**: You will create _default_ `beans` in `edu.umd.enpm614.assignment2.StandardConfig` that will bind: 
    * FrontendHTML for Frontend
    * MiddlewareTomcat for Middleware
    * PersistenceMySQL for Persistence
    * AuthenticationSSL for Authentication
    * FileSystemNTFS for FileSystem
    * ConnectionPooled for Connection

1. **Task 3 (20 points)**: You will create additional `beans` in `edu.umd.enpm614.assignment2.AdditionalConfig` that will bind: 
    * FrontendGWT
    * MiddlewareJBose 
    * PersistenceOracle 
    * AuthenticationTSL 
    * FileSystemNFS
    * ConnectionJDBC 
    
    In addition, you will use Spring AOP to create a logging interceptor (aspect) in `edu.umd.enpm614.assignment2` 
    named `LoggingAspect` that tracks all method calls of subclasses of Frontend, Middleware and Persistence. 

    Your logs should be in the format: `Logging Aspect: QualifiedClassName.methodName`

## Running the Application

**Prerequisites:**
- Java 17 or higher installed (`java -version` to verify)
- Complete the assignment implementation first (tasks must be done before running)

**Step 1: Build the Project**

Navigate to the project directory and build:

*Windows - Command Prompt (cmd.exe):*
```cmd
gradlew.bat build
```

*Windows - PowerShell:*
```powershell
.\gradlew.bat build
```

*Mac/Linux:*
```shell
./gradlew build
```

**Note:** The build automatically runs tests. If tests fail with "NoSuchBeanDefinitionException" or "UnsatisfiedDependencyException", that's expected—it means your implementation is incomplete. Fix the tasks and rebuild. Once all tasks are properly implemented, the build will succeed.

**Step 2: Run Tasks**

Once the build succeeds, you can run the application:

*Windows - Command Prompt (cmd.exe):*
```cmd
rem Run with Task 1 profile
gradlew.bat bootRun --args="--spring.profiles.active=task1"

rem Run with Task 2 profile
gradlew.bat bootRun --args="--spring.profiles.active=task2"

rem Run with default profile
gradlew.bat bootRun
```

*Windows - PowerShell:*
```powershell
# Run with Task 1 profile
.\gradlew.bat bootRun --args="--spring.profiles.active=task1"

# Run with Task 2 profile
.\gradlew.bat bootRun --args="--spring.profiles.active=task2"

# Run with default profile
.\gradlew.bat bootRun
```

*Mac/Linux:*
```shell
# Run with Task 1 profile
./gradlew bootRun --args="--spring.profiles.active=task1"

# Run with Task 2 profile
./gradlew bootRun --args="--spring.profiles.active=task2"

# Run with default profile
./gradlew bootRun
```

**Expected Output:**
When the application runs successfully, you should see console output showing the services being instantiated and their methods being called (especially with the LoggingAspect logging in Task 3). 
