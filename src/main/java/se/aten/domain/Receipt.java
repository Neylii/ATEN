package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Gabay
 * Entity class for recipt of a purchase
 */

@Entity
public class Receipt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;
    @ManyToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    //@OneToMany(cascade = CascadeType.MERGE)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<ReceiptProduct> products = new ArrayList<>();
    private Timestamp dateOfPurchase = new Timestamp(System.currentTimeMillis());
    private double total;

    public Receipt() {}

    public Receipt(double total) {
        this.total = total;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReceiptProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ReceiptProduct> products) {
        this.products = products;
    }

    public Timestamp getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Timestamp dateOfPurchase) {
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
                ", user=" + user +
                ", products=" + products +
                ", dateOfPurchase=" + dateOfPurchase +
                ", total=" + total +
                '}';
    }
}
