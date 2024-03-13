package nordicwh.basiccommerce.model;

import nordicwh.basiccommerce.controller.Products;

import java.util.Date;

public class Sale {
    private int idNumber_sale;
    private double total;
    private Date date;
    private int idNumber_client;
    private Client client;
    private Products listProduct;
    private Payment payment;
    private int idNumber_payment;

    public Sale(Date date, Client client, Products listProduct, Payment payment) {
        this.date = date;
        this.client = client;
        this.listProduct = listProduct;
        this.payment = payment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
