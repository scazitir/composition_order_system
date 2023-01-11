package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){};

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        items.remove(orderItem);
    }

    public Double total(){
        double sum = 0.0;
        for (OrderItem orderItem : items){
            sum += orderItem.subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ")
                .append(sdf.format(moment))
                .append("\nOrder Status: ")
                .append(status)
                .append("\nCostumer: ")
                .append(client)
                .append("\nOrder Items:")
                .append("\n");
                for (OrderItem orderItem : items){
                    sb.append(orderItem)
                            .append("\n");
                }

                sb.append("Total: $")
                    .append(String.format("%.2f", total()));

        return sb.toString();
    }
}
