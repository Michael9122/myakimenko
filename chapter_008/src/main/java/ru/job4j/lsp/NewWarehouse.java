package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class NewWarehouse extends Warehouse {
    private List<RepFood> foodList = new ArrayList<>();

    public boolean execute(RepFood food) {
        boolean result = false;
        if (super.execute(food) && food.isCold()) {
            foodList.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public List getList() {
        return this.foodList;
    }

    @Override
    public void clear() {
        foodList.clear();
    }
}
