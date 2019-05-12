package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class ColdStorage extends Decorator {
    private List<Strategy> foodList = new ArrayList<>();

    public ColdStorage(Strategy decoratorStrategy) {
        super(decoratorStrategy);
    }

    @Override
    public boolean execute(Food food) {
        setColdStorage();
        return super.execute(food);
    }

    @Override
    public List getList() {
        return foodList;
    }

    @Override
    public void clear() {
        foodList.clear();
    }

    private void setColdStorage() {
        System.out.println("Склад с низкой температурой");
    }
}
