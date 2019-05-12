package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private Strategy strategy;

    private List<Strategy> list = new ArrayList<>();

    public ControlQuality() {
        init();
    }

    private void init() {
        list.add(new Warehouse());
        list.add(new Trash());
        list.add(new Shop());
        list.add(new ColdStorage(new Warehouse()));
        list.add(new NewWarehouse());
    }

    public ControlQuality(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Food food) {
        return strategy.execute(food);
    }

    public void add(RepFood food) {
        for (Strategy strategy : list) {
            if (strategy.execute(food)) {
                strategy.execute(food);
                break;
            }
        }
    }

    public void resort() {
        List<RepFood> foods = new ArrayList<>();
        for (Strategy strategy : list) {
            foods.addAll(strategy.getList());
            strategy.clear();
        }
        foods.forEach(this::add);
    }
}
