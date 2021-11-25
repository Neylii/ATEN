package se.aten.domain;

import org.springframework.beans.factory.annotation.Autowired;
import se.aten.repository.ArticleRepository;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="tbl_Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String name;
    private String description;
    @Column(unique = true, nullable = false)
    private String SKU;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "categoryId")
    private ProductCategory categoryId;
    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "inventoryId")
    private ProductInventory inventoryId;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "discountId")
    private Discount discountId;
    private Timestamp createdAt;

    public Product() {
    }

    public Product(String name, String desc, String SKU, double price, ProductCategory productCategory, ProductInventory productInventory) {
        this.name = name;
        this.description = desc;
        this.SKU = SKU;
        this.price = price;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.categoryId = productCategory;
        this.inventoryId = productInventory;
        // System.out.println(this.createdAt.getTime());        // För att få 16165771233114
    }

    @Override
    public String toString() {
        return "Product: " + name  + ". Price: " + price;
    }
}
