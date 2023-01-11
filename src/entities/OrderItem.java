package entities;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        price = subTotal();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public double subTotal(){
        return quantity * product.getPrice();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName())
                .append(", $")
                .append(String.format("%.2f", product.getPrice()))
                .append(", Qty: ")
                .append(quantity)
                .append(", Sub: $")
                .append(String.format("%.2f", subTotal()));

        return sb.toString();
    }
}
