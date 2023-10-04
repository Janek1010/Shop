package com.example.shop.dataInitializing;

import com.example.shop.services.CustomerService;
import com.example.shop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class AppCommandLineRunner implements CommandLineRunner {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        try (Scanner myScanner = new Scanner(System.in);){
            while (true){
                showAvailableCommands();
                switch (myScanner.nextInt()){
                    case 1 -> customerService.findAllCustomers().forEach(System.out::println);
                    case 2 -> orderService.findAllOrders().forEach(System.out::println);
                    case 3 -> System.out.println(3);
                    case 4 -> System.out.println(4);
                    default -> throw new Exception();
                }
            }
        } catch (Exception e){
            System.out.println("Na razie!");
        }

    }
    private static void showAvailableCommands(){
        System.out.println();
        System.out.println("Valid Commands, type number of command:");
        System.out.println("1. Listing of all categories");
        System.out.println("2. Listing of all elements");
        System.out.println("3. Adding new element with category selection");
        System.out.println("4. Deleting existing element");
        System.out.println("Type something else to exit");
        System.out.println();
    }
}
