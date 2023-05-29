package com.example.restaurant;

import model.Dish;
import org.springframework.web.bind.annotation.*;
import services.DishService;

import java.util.List;

@RestController
public class DishController {
    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }


    @GetMapping("/menu")
    public List<Dish> getMenu() {
        return service.getMenu();
    }

    @PostMapping("/dish")
    public void addDish(@RequestBody Dish dish) {
        service.addDish(dish);
    }

    @PatchMapping("/dish/{id}")
    public Dish updateDish(@RequestBody Dish dishDto, @PathVariable("id") Integer dishId) {
        return service.updateDish(dishDto, dishId);
    }

    @DeleteMapping("/dish/{id}")
    public void deleteDish(@PathVariable("id") Integer dishId) {
        service.deleteDish(dishId);
    }
}