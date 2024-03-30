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

    public Client(Client client) {
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.name = client.getName();
        //this.payments = client.get
    }

    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

//    public int getIdNumber_client() {
//        return idNumber_client;
//    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addPayments(Payment payment) {
        return payments.add(payment);
    }

    public boolean removePayments(Payment payment) {
        return payments.remove(payment);
    }
}
