package repos;

import model.Dish;
import services.DishService;

import java.util.ArrayList;
import java.util.List;

public interface DishRepository {

    List<Dish> dishes = new ArrayList<>();

    default List<Dish> getMenu() {
        return dishes;
    }

    default Dish save(int id, String name, String description, int price, int quantity) {
        Dish d = new Dish();
        d.setId(id);
        d.setName(name);
        d.setDescription(description);
        d.setPrice(price);
        d.setQuantity(quantity);
        dishes.add(d);
        return d;
    }

    default void deleteById(Integer dishId) {
        //ищем блюдо
        Dish dishToDelete = null;
        for (Dish dish : dishes) {
            if (dish.getId() == dishId) {
                dishToDelete = dish;
                break;
            }
        }

        // Если блюдо найдено, удаляем его из списка
        if (dishToDelete != null) {
            dishes.remove(dishToDelete);
            System.out.println("Блюдо успешно удалено.");
        } else {
            System.out.println("Блюдо с указанным идентификатором не найдено.");
        }
    }

    default Dish findById(Integer dishId) {
        //ищем блюдо
        Dish dishToFind = null;
        for (Dish dish : dishes) {
            if (dish.getId() == dishId) {
                dishToFind = dish;
                break;
            }
        }

        // Если блюдо найдено, возвращаем его
        if (dishToFind != null) {
            System.out.println("Блюдо успешно найдено.");
            return dishToFind;
        } else {
            System.out.println("Блюдо с указанным идентификатором не найдено.");
            return null;
        }
    }
}
