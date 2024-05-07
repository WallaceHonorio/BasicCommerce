package basiccommerce.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double total;

    private LocalDate date = LocalDate.now();

    @ManyToOne
    private Client client;

//    @ManyToMany
//    @JoinTable()
//    private List<Product> productList;

    @OneToMany(mappedBy = "order")
    private List<OrderItems> itemsList = new ArrayList<>();

    public Order(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addItemsList(OrderItems item) {
        //OrderItems know the order
        item.setOrder(this);

        //Order know the item
        this.itemsList.add(item);
    }
}
