package services;

import model.Dish;
import repos.DishRepository;

import java.util.ArrayList;
import java.util.List;

public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getMenu() {
        return dishRepository.getMenu();
    }

    public void addDish(Dish dish) {
        dishRepository.save(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice(), dish.getQuantity());
    }

    public Dish updateDish(Dish dishDto, Integer dishId) {
        if (dishRepository.findById(dishId) != null) {
            Dish dish = dishRepository.findById(dishId);
            dish.setName(dishDto.getName());
            dish.setDescription(dishDto.getDescription());
            dish.setPrice(dishDto.getPrice());
            dish.setQuantity(dishDto.getQuantity());
            return dishRepository.save(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice(), dish.getQuantity());
        } else {
            throw new RuntimeException("Указанного блюда не существует");
        }

    }

    public void deleteDish(Integer dishId) {
        dishRepository.deleteById(dishId);
    }
}
