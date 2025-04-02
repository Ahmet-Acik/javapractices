package org.ahmet.functionalInterfaces;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        MyFunctionalInterface myFunc = () -> System.out.println("Hello, World!");
        myFunc.doSomething();

        // Using a method reference to call a default method
        myFunc.defaultMethod();

        // Using a method reference to call a static method
        MyFunctionalInterface.printMessage();

    }

}
