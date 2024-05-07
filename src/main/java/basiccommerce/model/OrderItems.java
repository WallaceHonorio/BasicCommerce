package basiccommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double unitPrice;

    private int amount;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    public OrderItems() {
    }

    public OrderItems(int amount, Order order, Product product) {
        this.amount = amount;
        this.order = order;
        this.product = product;
        this.unitPrice = product.getPrice();
    }

    public int getId() {
        return id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

}
