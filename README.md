# SpringCoreProject-Employee

## Overview
This project demonstrates the use of Spring Core to manage entities `Employee` and `Project` with a many-to-many relationship. The project uses Spring's dependency injection to wire beans and manage the lifecycle of objects.

## Project Structure
```
SpringCoreProject-Employee/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jsp/
│   │   │   │   │   ├── springcore/
│   │   │   │   │   │   ├── employee_project/
│   │   │   │   │   │   │   ├── entity/
│   │   │   │   │   │   │   │   ├── Employee.java
│   │   │   │   │   │   │   │   ├── Project.java
│   │   │   │   │   │   │   ├── App.java
│   │   ├── resources/
│   │   │   ├── springProject.xml
│   ├── test/
│
├── README.md
```

## Entities

### Employee
The `Employee` class represents an employee with the following properties:
- `employeeId`: Unique identifier for the employee.
- `employeeName`: Name of the employee.
- `email`: Email address of the employee.
- `salary`: Salary of the employee.
- `project`: List of projects the employee is associated with.

```java
@Entity
public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    private String email;
    private int salary;
    
    @ManyToMany
    private List<Project> project;
    
    // Getters and setters
    // toString method
}
```

### Project
The `Project` class represents a project with the following properties:
- `projectId`: Unique identifier for the project.
- `projectName`: Name of the project.
- `techStack`: Technology stack used in the project.
- `employees`: List of employees associated with the project.

```java
@Entity
public class Project {
    @Id
    private int projectId;
    private String projectName;
    private String techStack;
    
    @ManyToMany
    private List<Employee> employees;
    
    // Getters and setters
    // toString method
}
```

## Spring Configuration

### springProject.xml
The `springProject.xml` file defines the beans for `Employee` and `Project` entities and their relationships.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- Bean Definition -->
    
    <bean id="employee1" class="com.jsp.springcore.employee_project.entity.Employee" autowire="byType">
        <property name="employeeId" value="101"></property>
        <property name="employeeName" value="Vivek"></property>
        <property name="email" value="vivek@gmail.com"></property>
        <property name="salary" value="550000"></property>
    </bean>
    
    <!-- Additional employee beans -->
    
    <bean id="project1" class="com.jsp.springcore.employee_project.entity.Project" autowire="no">
        <property name="projectId" value="1"></property>
        <property name="projectName" value="Zomato"></property>
        <property name="techStack" value="JAVA"></property>
        <property name="employees">
            <list>
                <ref bean="employee1"/>
                <ref bean="employee2"/>
            </list>
        </property>
    </bean>
    
    <!-- Additional project beans -->
    
</beans>
```

## Running the Application
To run the application, execute the `App.java` class which loads the Spring context and retrieves the beans.

```java
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springProject.xml");
        
        Employee employee1 = context.getBean("employee1", Employee.class);
        System.out.println(employee1);
        
        Project project1 = context.getBean("project1", Project.class);
        System.out.println(project1);
    }
}
```

## Output
The output will display the details of the `Employee` and `Project` beans without causing a `StackOverflowError` due to the changes made to the `toString` methods.

```
Employee{employeeId=101, employeeName='Vivek', email='vivek@gmail.com', salary=550000, projects=[Zomato, Swigy, Rapido, Ola]}
Project{projectId=1, projectName='Zomato', techStack='JAVA', employees=[Vivek, Vinay]}
