package se.aten.domain;

import javax.persistence.*;

/**
 * Entity class for user address.
 *
 * @author Emma Fredriksson
 */
@Entity
@Table(name = "tbl_UserAddress")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    @ManyToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;

    public UserAddress() {

    }

    public UserAddress(String address, String city, String country, String phoneNumber) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "user=" + user +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}