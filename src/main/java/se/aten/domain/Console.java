package se.aten.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @author Alex Gabay
 * Class for console extending Product.
 */

@Entity
public class Console extends Product implements Serializable {
    @Enumerated(EnumType.STRING)
    private ConsoleType brand;
    private String model;

    public Console() {}

    public Console(ConsoleType brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Console(String name, String desc, double price, ConsoleType brand, String model) {
        super(name, desc, price);
        this.brand = brand;
        this.model = model;
    }

    public ConsoleType getBrand() {
        return brand;
    }

    public void setBrand(ConsoleType brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Console{" +
                "brand=" + brand +
                ", model='" + model + '\'' +
                '}';
    }
}
