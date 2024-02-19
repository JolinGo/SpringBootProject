package com.example.learnspringframework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1. Launch a Spring Context
        try(var context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. Configure the things that we want Spring to manage - @Configuration
            // HelloWorldConfigration - @Configuration
            // eg. name - @Bean

            // 3. Retrieving Beans managed by spring
            System.out.println("name: " + context.getBean("name"));
            System.out.println("age: " + context.getBean("age"));
            System.out.println("person: " + context.getBean("person"));
            System.out.println("person2MethodCall: " +  context.getBean("person2MethodCall"));
            System.out.println("person3Parameters: " + context.getBean("person3Parameters"));
            System.out.println("address2: " + context.getBean("address2"));

            System.out.println("Person.class: " + context.getBean(Person.class));
            System.out.println("Address.class: " + context.getBean(Address.class));

            System.out.println("person5QualifierString: " + context.getBean("person5QualifierString"));

//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);

        }
    }
}
