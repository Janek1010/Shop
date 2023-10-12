package com.example.shop.dataInitializing;

import com.example.shop.entities.Customer;
import com.example.shop.entities.Order;
import com.example.shop.services.CustomerService;
import com.example.shop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AppCommandLineRunner implements CommandLineRunner {
    private final CustomerService customerService;
    private final OrderService orderService;

    // Optionale porobić i popatrzec projekt wojcika !!!!
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        try (Scanner myScanner = new Scanner(System.in);){
            while (true){
                showAvailableCommands();
                switch (myScanner.nextInt()){
                    case 1 -> customerService.findAllCustomers().forEach(System.out::println);
                    case 2 -> orderService.findAllOrders().forEach(System.out::println);
                    case 3 -> addNewOrder(myScanner);
                    case 4 -> deleteExistingElement(myScanner);
                    case 5 -> showTree();
                    default -> throw new Exception();
                }
            }
        } catch (Exception e){
            System.out.println("Na razie!");
        }

    }

    private void deleteExistingElement(Scanner myScanner) {
        System.out.println("Type number of customer from you want to remove order (numeration from 0)");
        List<Customer> customers = customerService.findAllCustomers();
        customers.forEach(System.out::println);
        while (true){
            int number = myScanner.nextInt();
            if (number>=0 && number < customers.size()){
                Customer  customer = customers.get(number);
                List<Order> orders = orderService.findByCustomerName(customer.getName());
                System.out.println("Type number of order that you want to remove (numeration from 0)");
                orders.forEach(System.out::println);
                Integer indexToRemove = myScanner.nextInt();
                orderService.deleteOrderById(orders.get(indexToRemove).getId());
                System.out.println("Check if your order isn't below!");
                orderService.findByCustomerName(customer.getName()).forEach(System.out::println);
                break;
            }
            System.out.println("number out of bounds!");
        }
    }

    private void showTree() {
        for (var c: customerService.findAllCustomers()) {
            System.out.println(c);
            for (var o: c.getOrders()) {
                System.out.println("    "+o+" existsInOrderRepository: " + orderService.existsById(o.getId()));
            }
        }
    }
    private void addNewOrder(Scanner myScanner){
        System.out.println("Type number of customer that will get new order (numeration from 0)");
        List<Customer> customers = customerService.findAllCustomers();
        customers.forEach(System.out::println);
        while (true){
            int number = myScanner.nextInt();
            if (number>=0 && number < customers.size()){
                Customer  customer = customers.get(number);
                System.out.println("Type product name and quantity (every value accept with enter)");
                myScanner.nextLine(); // pobieram linie co przeszkadza
                Order order= Order.builder().customer(customer).productName(myScanner.nextLine().trim()).id(UUID.randomUUID()).quantity(myScanner.nextInt()).build();
                orderService.saveNewOrder(order);
                System.out.println("Check if your order is below!");
                orderService.findByCustomerName(customer.getName()).forEach(System.out::println);
                break;
            }
            System.out.println("number out of bounds!");
        }
    }

    private static void showAvailableCommands(){
        System.out.println();
        System.out.println("Valid Commands, type number of command:");
        System.out.println("1. Listing of all categories");
        System.out.println("2. Listing of all elements");
        System.out.println("3. Adding new element with category selection");
        System.out.println("4. Deleting existing element");
        System.out.println("5. Show tree");
        System.out.println("Type something else to exit");
        System.out.println();
    }
}
