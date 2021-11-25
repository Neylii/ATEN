package se.aten.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Class for keeping inventory on all the products
 * @author Tom Karlsson
 */
@Entity
@Table(name="tbl_ProductInventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventoryId;
    private int quantity;
    private Timestamp createdAt;

    public ProductInventory() {

    }

    public ProductInventory(int quantity) {
        this.quantity = quantity;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        // System.out.println(this.createdAt.getTime());        // För att få 1616577123311
    }
}