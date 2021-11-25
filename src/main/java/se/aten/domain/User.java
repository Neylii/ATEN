package se.aten.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This class represents a User that can login to the application.
 *
 * @author Niklas Johansson
 */
@Entity
@Table(name = "tbl_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerNumber;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp createdAt;

    public User() {}

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getCustomerNumber() {return customerNumber;}

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}