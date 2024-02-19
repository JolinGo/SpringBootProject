package com.example.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) { };
record Address(String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        var person = new Person("Flora", 3, new Address("Main Street", "Seattle"));
        return person;
    }

    @Bean
    public Person person2MethodCall() {
        var person = new Person(name(), age(), address());
        return person;
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    @Qualifier("person5QualifierString")
    public Person person5QualifierString(String name, int age, @Qualifier("address3qualifier") Address address3) {
        return new Person(name, age, address3);
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        var address = new Address("Baker Street", "London");
        return address;
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Motinagar", "New York");
    }

}
