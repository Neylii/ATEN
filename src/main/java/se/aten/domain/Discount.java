package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * Class for if products are on discount or not
 * @author Tom Karlsson
 */
@Entity
@Table(name="tbl_Discount")
public class Discount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="discountId")
    private int id;
    private String name;
    private String description;
    private double discountPercent;
    private boolean active;
    private Timestamp createdAt;

    public Discount() {
    }

    public Discount(String name, String desc, double discountPercent, boolean active) {
        this.name = name;
        this.description = desc;
        this.discountPercent = discountPercent;
        this.active = active;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        // System.out.println(this.createdAt.getTime());        // För att få 1616577123311
    }
}
