package se.aten.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_ProductCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String name;
    private String description;

    public ProductCategory(){}

    public ProductCategory(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    @Override
    public String toString() {
        return "productCategory{" +
                "id=" + categoryId +
                ", name='" + name + '\'' +
                ", desc='" + description + '\'' +
                '}';
    }
}