package org.ahmet;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String email;
    private LocalDate dateOfBirth;
    private List<Product> purchases;

    public User(String name, int age, String email, LocalDate dateOfBirth, List<Product> purchases) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.purchases = purchases;
    }

    // Getters and setters for all fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "', dateOfBirth=" + dateOfBirth + ", purchases=" + purchases + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(purchases, user.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, dateOfBirth, purchases);
    }
}