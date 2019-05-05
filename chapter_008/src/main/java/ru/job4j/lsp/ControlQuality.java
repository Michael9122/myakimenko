package ru.job4j.lsp;

public class ControlQuality {
    private Strategy strategy;

    public ControlQuality() {
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
}
