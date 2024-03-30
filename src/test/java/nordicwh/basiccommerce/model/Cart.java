package nordicwh.basiccommerce.model;

import nordicwh.basiccommerce.controller.Products;
import nordicwh.basiccommerce.model.Payment;

public class Cart {
    private double total = 0;
    private int idNumber_client;
    private Client client;
    private Products listProduct;

    public Cart(Client client) {
        this.client = new Client(client);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
