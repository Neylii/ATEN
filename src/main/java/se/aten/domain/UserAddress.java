package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity class for user address.
 * This object is part of the whole User
 * @author Emma Fredriksson
 */
@Entity
@Table(name="tbl_UserAddress")
public class UserAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    @ManyToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phoneNumber;

    public UserAddress() {
    }

    /**
     * Constructor for creating an address. This object is a part of the whole User-object.
     * @param address the streetaddress
     * @param zipcode a zipcode
     * @param city a city
     * @param country the country
     * @param phoneNumber the users phonenumber
     */
    public UserAddress(String address, String zipcode, String city, String country, String phoneNumber) {
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "addressId=" + addressId +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}