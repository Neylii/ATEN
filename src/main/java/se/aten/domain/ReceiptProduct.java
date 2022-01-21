package se.aten.domain;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class ReceiptProduct {
    @ManyToOne
    private Product product;
    private int quantity;

    public ReceiptProduct() {}

    public ReceiptProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptProduct that = (ReceiptProduct) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
