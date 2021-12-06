package se.aten.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Alex Gabay
 * Entity class for recipt of a purchase
 */

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customerNumber")
    private User customerId;
    @OneToMany
    private List<Product> products;
    private Date dateOfPurchase;
    private double total;

    public Receipt() {}

    public Receipt(User customerId, List<Product> products, Date dateOfPurchase, double total) {
        this.customerId = customerId;
        this.products = products;
        this.dateOfPurchase = dateOfPurchase;
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", customerNumber=" + customerId +
                ", products=" + products +
                ", dateOfPurchase=" + dateOfPurchase +
                ", total=" + total +
                '}';
    }
}
