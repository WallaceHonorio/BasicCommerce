package nordicwh.basiccommerce.model;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private int idNumber_client;
    private final String email;
    private String password;
    private String name;
    private List<Payment> payments = new ArrayList<>();


    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

//    public int getIdNumber_client() {
//        return idNumber_client;
//    }

    public java.lang.String getEmail() {
        return email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public boolean addPayments(Payment payment) {
        return payments.add(payment);
    }

    public boolean removePayments(Payment payment) {
        return payments.remove(payment);
    }
}
