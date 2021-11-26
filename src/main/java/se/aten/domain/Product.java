package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
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

    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        // System.out.println(this.createdAt.getTime());        // För att få 16165771233114
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
