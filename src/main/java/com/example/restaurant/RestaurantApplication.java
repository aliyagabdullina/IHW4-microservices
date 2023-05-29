package com.example.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static databases.dish.createDishTable;
import static databases.order.createOrderTable;
import static databases.session.createSessionTable;
import static databases.user.createUserTable;

@SpringBootApplication
public class RestaurantApplication {

    public static void main(String[] args) throws SQLException {
		createUserTable();
		createSessionTable();
		createDishTable();
		createOrderTable();
		SpringApplication.run(RestaurantApplication.class, args);
    }

}
