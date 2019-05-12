package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 06.05.2019
 */
public class Shop implements Strategy {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public boolean execute(Food food) {
        boolean result = false;
        double first = food.getExpiryDate().toEpochDay() - LocalDate.now().toEpochDay();
        double second = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        double percent = first / second * 100;
        if ((percent >= 25) && (percent <= 75)) {
            foodList.add(food);
            result = true;
        } else if (percent > 75) {
            food.setPrice(food.getPrice() - food.getDiscount());
            foodList.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public List getList() {
        return foodList;
    }

    @Override
    public void clear() {
        foodList.clear();
    }
}
