package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Class representing a base product.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String name;
    private String description;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "discountId")
    private Discount discountId;
    private Timestamp createdAt;

    public Product() {
    }

    /**
     * Constructor for creating a product.
     * @param name a name for the product
     * @param desc a fitting description of what the product is
     * @param price the amount a user have to pay to be able to purchase the product
     */
    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(discountId, product.discountId) && Objects.equals(createdAt, product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, price, discountId, createdAt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Discount discountId) {
        this.discountId = discountId;
    }

    public long getProductId() {
        return productId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Product: " + name + ". Price: " + price;
    }
}
