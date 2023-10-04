package com.example.shop.dataInitializing;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppCommandLineRunner implements CommandLineRunner {
    private final DataInitializer dataInitializer;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("halo halo");
       // dataInitializer.initializeData();
    }
}
