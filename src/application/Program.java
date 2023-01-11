package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

// https://www.udemy.com/course/java-curso-completo/learn/lecture/10793894#overview
// https://github.com/devsuperior/aulao004

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Locale.setDefault(Locale.CANADA);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter costumer's information: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth date (YYYY/MM/DD): ");
        Date birthDate = sdf.parse(scan.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order's information: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many products would like to add? ");
        int qtyProduct = scan.nextInt();
        for (int i = 1; i <= qtyProduct; i++){
            System.out.println("Product #" + i + ": ");
            System.out.print("Product name: ");
            String productName = scan.next();
            System.out.print("Product price: $");
            double productPrice = scan.nextDouble();
            System.out.print("Quantity: ");
            int productQty = scan.nextInt();

            OrderItem orderItem = new OrderItem(productQty, new Product(productName, productPrice));

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("Order Summary: ");
        System.out.println(order);

        scan.close();
    }
}
