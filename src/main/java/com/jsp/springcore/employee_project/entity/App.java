package com.jsp.springcore.employee_project.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springProject.xml");
        
        //Employee
        Employee employee1 = (Employee) ac.getBean("employee1");
        System.out.println(employee1);
        
        Employee employee2 = (Employee) ac.getBean("employee2");
        System.out.println(employee2);
        
        Employee employee3 = (Employee) ac.getBean("employee3");
        System.out.println(employee3);
        
        Employee employee4 = (Employee) ac.getBean("employee4");
        System.out.println(employee4);
        
        //Project
        Project project1 = (Project) ac.getBean("project1");
        System.out.println(project1);
        
        Project project2 = (Project) ac.getBean("project2");
        System.out.println(project2);
        
        Project project3 = (Project) ac.getBean("project3");
        System.out.println(project3);
        
        Project project4 = (Project) ac.getBean("project4");
        System.out.println(project4);
    }
}
