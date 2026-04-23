package com.jieyang.customermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "First name is required")
    @Size(min = 2, message = "First name must be at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last name must be at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", unique = true)
    private String email;

    // constructors

    public Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getters & setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName +
                ", lastName=" + lastName + ", email=" + email + "]";
    }
}