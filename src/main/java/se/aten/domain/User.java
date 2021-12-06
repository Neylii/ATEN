package se.aten.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a User that can login to the application.
 *
 * @author Niklas Johansson
 * @author Emma Fredriksson
 */
@Entity
@Table(name="tbl_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @OneToMany(
            mappedBy = "addressId",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<UserAddress> userAddresses = new ArrayList<>();
    @OneToMany
    private List<Receipt>userReceipts = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, UserAddress userAddress) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddresses.add(userAddress);
    }

    public void addAddress(UserAddress userAddress) {
        this.userAddresses.add(userAddress);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public List<Receipt> getUserReceipts() {
        return userReceipts;
    }

    public void setUserReceipts(List<Receipt> userReceipts) {
        this.userReceipts = userReceipts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", userAddresses=" + userAddresses +
                '}';
    }
}